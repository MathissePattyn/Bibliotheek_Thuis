package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public abstract class User {
    protected Scanner scanner;
    private String naam;
    private int id;
    private String wachtwoord;

    public User(String naam, Scanner scanner, int id, String wachtwoord) {
        this.naam = naam;
        this.scanner = scanner;
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

    public abstract void showMenu(Bibliotheek bib);

    public abstract User maakUserAan(Bibliotheek bib);
}


