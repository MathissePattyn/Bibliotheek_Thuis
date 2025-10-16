package be.vives.ti;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class OpenLibraryService {

    public static Boek haalBoekOpViaISBN(String isbn){
        try {
            String url = "https://openlibrary.org/isbn/" + isbn + ".json";
            System.out.println("Requesting URL: " + url);

            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("HTTP status code: " + response.statusCode());
//            System.out.println("Response body: " + response.body());

            JSONObject json = new JSONObject(response.body());

            JSONArray isbnArray = json.getJSONArray("isbn_13");
            String Isbn = isbnArray.getString(0);
            String titel = json.getString("title");

            JSONArray authorsArray = json.getJSONArray("authors");
            ArrayList<String> auteurs = new ArrayList<>();
            for(int i = 0; i<authorsArray.length();i++){
                JSONObject authorObj = authorsArray.getJSONObject(i);
                String authorKey = authorObj.getString("key");
                JSONObject authorJSON = haalJSONOp("https://openlibrary.org/"+authorKey+".json");
                String naam = authorJSON.getString("name");
                auteurs.add(naam);
            }
            int aantalPaginas = json.getInt("number_of_pages");
            String publicatieJaar = json.getString("publish_date");

            Boek boek = new Boek(Isbn, auteurs,titel,publicatieJaar,aantalPaginas);
            return boek;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            return new JSONObject(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
