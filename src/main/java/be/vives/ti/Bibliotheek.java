package be.vives.ti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Bibliotheek {
    private ArrayList<Lid> leden;
    private ArrayList<Clerk> winkelBedienden;
    private ArrayList<Boek> boeken;
    private HashMap<Lid, ArrayList<Boek>> lidMetBoeken;

    public Bibliotheek() {
        this.leden = new ArrayList<>();
        this.boeken = new ArrayList<>();
        this.lidMetBoeken = new HashMap<>();
        this.winkelBedienden = new ArrayList<>();
    }

    public void addBoekViaIsbn(String isbn){boeken.add(OpenLibraryService.haalBoekOpViaISBN(isbn));}

    public void verwijderBoekViaISBN(String isbn){
        Iterator<Boek> it = boeken.iterator();
        while(it.hasNext()){
            Boek boek = it.next();
            if(boek.getISBN().equals(isbn)){
                it.remove();
            }
        }
    }

    public ArrayList<Lid> getLeden() {
        return leden;
    }

    public ArrayList<Clerk> getWinkelBedienden() {
        return winkelBedienden;
    }

    public ArrayList<Boek> getBoeken() {
        return boeken;
    }

    public HashMap<Lid, ArrayList<Boek>> getLidMetBoeken() {
        return lidMetBoeken;
    }
}
