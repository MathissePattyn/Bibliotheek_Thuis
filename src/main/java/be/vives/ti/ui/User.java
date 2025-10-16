package be.vives.ti.ui;

import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public abstract class User {
    protected Scanner scanner;
    private String naam;

    public User(String naam, Scanner scanner) {
        this.naam = naam;
        this.scanner = scanner;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public abstract void showMenu(Bibliotheek bib);
}


