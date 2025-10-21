package be.vives.ti.service;

import be.vives.ti.exceptions.BoekNietGevondenException;
import be.vives.ti.model.Clerk;
import be.vives.ti.model.Boek;
import be.vives.ti.model.Lid;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Bibliotheek {
    private ArrayList<Lid> leden;
    private ArrayList<Clerk> winkelBedienden;
    private ArrayList<Boek> boeken;
    private HashMap<Lid, ArrayList<Boek>> lidMetBoeken;
    private final String boekBestand = "boeken.json";
    private final String clerkBestand = "clerks.json";
    private final Gson gson = new Gson();

    public Bibliotheek() {
        this.leden = laadLeden();
        this.boeken = laadBoeken();
        this.lidMetBoeken = new HashMap<>();
        this.winkelBedienden = laadWinkelbedienden();

    }

    private ArrayList<Lid> laadLeden() {
        return new ArrayList<>();
    }


    public void addBoekViaIsbn(String isbn){
        try {
            Boek boek = OpenLibraryService.haalBoekOpViaISBN(isbn);
            if(getIndexVanBoek(isbn) == -1) {
                boeken.add(boek);
                System.out.println("Boek toegevoegd: " + boek.getTitel() + "\n");
                slaBoekenOp();
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
            slaBoekenOp();
        }
    }

    public ArrayList<Boek> getBoeken() {return boeken;}

    public String getDetailsLijstVanBoeken() {
        StringBuilder sb = new StringBuilder();
        if (getBoeken() != null && !getBoeken().isEmpty()) {
            for (int i = 0; i < boeken.size(); i++) {
                Boek boek = boeken.get(i);
                sb.append((i + 1)).append(": ").append(boek.getTitel()).append(", isbn: ").append(boek.getISBN()).append("\n");
            }
            return sb.toString();
        }
        return "Geen boeken aanwezig in de bib";
    }

    public String getDetailsVanBoek(String isbn){
        StringBuilder sb = new StringBuilder();
        if(getIndexVanBoek(isbn) == -1){
            return "Boek niet gevonden" + "\n";
        } else{
            Boek boek = boeken.get(getIndexVanBoek(isbn));
            sb.append(boek.getISBN()).append(", ").append(boek.getTitel()).append(", ").append(boek.getAuteur()).append(", ").append(boek.getPublicatieJaar()).append(", ").append(boek.getAantalPaginas());
        }
        return sb.toString();
    }

    public ArrayList<Lid> getLeden() {
        return leden;
    }

    public ArrayList<Clerk> getWinkelBedienden() {return winkelBedienden;}

    public HashMap<Lid, ArrayList<Boek>> getLidMetBoeken() {return lidMetBoeken;}

    public void addClerk(Clerk clerk){
        winkelBedienden.add(clerk);
        slaClerkOp();
    }

    public void removeClerk(Clerk clerk){
        Iterator<Clerk> it = winkelBedienden.iterator();
        while(it.hasNext()){
            Clerk c = it.next();
            if(c.getId() == clerk.getId()){
                it.remove();
                slaClerkOp();
            }
        }
    }

    private void slaClerkOp() {
        try (Writer writer = new FileWriter(clerkBestand)){
            gson.toJson(winkelBedienden, writer);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void slaBoekenOp() {
        try(Writer writer = new FileWriter(boekBestand)){
            gson.toJson(boeken, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Clerk> laadWinkelbedienden() {
        File file = new File(clerkBestand);
        if(!file.exists()) return new ArrayList<>();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, new com.google.gson.reflect.TypeToken<ArrayList<Clerk>>(){}.getType());
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private ArrayList<Boek> laadBoeken() {
        File file = new File(boekBestand);
        if(!file.exists()) return new ArrayList<>();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, new com.google.gson.reflect.TypeToken<ArrayList<Boek>>(){}.getType());
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
