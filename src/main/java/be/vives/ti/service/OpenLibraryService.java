package be.vives.ti.service;

import be.vives.ti.exceptions.BoekNietGevondenException;
import be.vives.ti.model.Boek;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class OpenLibraryService {

    public static Boek haalBoekOpViaISBN(String isbn) throws BoekNietGevondenException {
        try {
            String url = "https://openlibrary.org/isbn/" + isbn + ".json";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Controleer HTTP-status
            if (response.statusCode() != 200) {
                throw new BoekNietGevondenException("ISBN niet gevonden: " + isbn);
            }

            JSONObject json = new JSONObject(response.body());

            // ISBN
            String isbnResult = isbn;
            if (json.has("isbn_13")) {
                JSONArray isbnArray = json.getJSONArray("isbn_13");
                if (isbnArray.length() > 0) {
                    isbnResult = isbnArray.getString(0);
                }
            }

            // Titel
            String titel = json.optString("title", "Onbekende titel");

            // Auteurs
            ArrayList<String> auteurs = new ArrayList<>();
            if (json.has("authors")) {
                JSONArray authorsArray = json.getJSONArray("authors");
                for (int i = 0; i < authorsArray.length(); i++) {
                    JSONObject authorObj = authorsArray.getJSONObject(i);
                    String authorKey = authorObj.optString("key", null);
                    if (authorKey != null) {
                        JSONObject authorJSON = haalJSONOp("https://openlibrary.org/" + authorKey + ".json");
                        auteurs.add(authorJSON != null ? authorJSON.optString("name", "Onbekend") : "Onbekend");
                    } else {
                        auteurs.add("Onbekend");
                    }
                }
            } else {
                auteurs.add("Onbekend");
            }

            // Pagina's
            int aantalPaginas = json.optInt("number_of_pages", 0);

            // Publicatiejaar
            String publicatieJaar = json.optString("publish_date", "Onbekend");

            return new Boek(isbnResult, auteurs, titel, publicatieJaar, aantalPaginas);

        } catch (IOException | InterruptedException e) {
            throw new BoekNietGevondenException("Fout bij ophalen ISBN " + isbn + ": " + e.getMessage());
        }
    }

    public static JSONObject haalJSONOp(String url) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return null;
            }

            return new JSONObject(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
