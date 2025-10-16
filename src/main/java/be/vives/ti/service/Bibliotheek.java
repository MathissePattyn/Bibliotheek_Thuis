package be.vives.ti.service;

import be.vives.ti.exceptions.BoekNietGevondenException;
import be.vives.ti.ui.Clerk;
import be.vives.ti.model.Boek;
import be.vives.ti.model.Lid;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void addBoekViaIsbn(String isbn){
        try {
            Boek boek = OpenLibraryService.haalBoekOpViaISBN(isbn);
            if(getIndexVanBoek(isbn) == -1) {
                boeken.add(boek);
                System.out.println("Boek toegevoegd: " + boek.getTitel() + "\n");
            } else {
                System.out.println("Boek zit al in de lijst" + "\n");
            }
        } catch (BoekNietGevondenException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getIndexVanBoek(String isbn){
        for(int i=0; i<boeken.size();i++){
            if(boeken.get(i).getISBN().equals(isbn)){
                return i;
            }
        }
        return -1;
    }

    public void verwijderBoekViaISBN(String isbn){
        if(getIndexVanBoek(isbn) == -1){
            System.out.println("Boek niet gevonden" + "\n");
        } else {
            boeken.remove(getIndexVanBoek(isbn));
        }
    }

    public ArrayList<Boek> getBoeken() {return boeken;}

    public String getDetailsLijstVanBoeken(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<boeken.size();i++){
            Boek boek = boeken.get(i);
            sb.append((i + 1)).append(": ").append(boek.getTitel()).append(", isbn: ").append(boek.getISBN()).append("\n");
        }
        return sb.toString();
    }

    public String getDetailsVanBoek(String isbn){
        StringBuilder sb = new StringBuilder();
        if(getIndexVanBoek(isbn) == -1){
            return "Boek niet gevonden" + "\n";
        } else{
            sb.append(boeken.get(getIndexVanBoek(isbn)).getTitel());
        }
        return sb.toString();
    }

    public ArrayList<Lid> getLeden() {
        return leden;
    }

    public ArrayList<Clerk> getWinkelBedienden() {return winkelBedienden;}

    public HashMap<Lid, ArrayList<Boek>> getLidMetBoeken() {return lidMetBoeken;}
}
