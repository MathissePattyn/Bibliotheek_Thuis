package be.vives.ti;

import java.util.Scanner;

public abstract class User {
    private String naam;

    public User(String naam) {
        this.naam = naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public abstract void showMenu(Bibliotheek bib, Scanner scanner);
}


