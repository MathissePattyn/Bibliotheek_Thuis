package be.vives.ti;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Boek {
    private String ISBN;
    private ArrayList<String> auteur;
    private String titel;
    private String publicatieJaar;
    private int aantalPaginas;
    private boolean isUitgeleend;

    public Boek(String ISBN, ArrayList<String> auteur, String titel, String publicatieJaar, int aantalPaginas) {
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.titel = titel;
        this.publicatieJaar = publicatieJaar;
        this.aantalPaginas = aantalPaginas;
        this.isUitgeleend = false; // standaard niet uitgeleend
    }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public ArrayList<String> getAuteur() { return auteur; }
    public void setAuteur(ArrayList<String> auteur) { this.auteur = auteur; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getPublicatieJaar() { return publicatieJaar; }
    public void setPublicatieJaar(String publicatieJaar) { this.publicatieJaar = publicatieJaar; }

    public int getAantalPaginas() { return aantalPaginas; }
    public void setAantalPaginas(int aantalPaginas) { this.aantalPaginas = aantalPaginas; }

    public boolean isUitgeleend() { return isUitgeleend; }
    public void setUitgeleend(boolean uitgeleend) { isUitgeleend = uitgeleend; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Boek boek = (Boek) o;
        return Objects.equals(ISBN, boek.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }
}
