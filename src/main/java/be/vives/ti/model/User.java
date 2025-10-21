package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public abstract class User {
    private String naam;
    private int id;
    private String wachtwoord;

    public User(String naam,int id, String wachtwoord) {
        this.naam = naam;
        this.id = id;
        this.wachtwoord = wachtwoord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

//    public abstract void showMenu(Bibliotheek bib);
//
//    public abstract User maakUserAan(Bibliotheek bib);
}


