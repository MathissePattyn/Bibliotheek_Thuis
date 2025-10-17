package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public class Lid extends User {
    private static int lidCounter = 0;

    public Lid(String naam, Scanner scanner, String wachtwoord) {
        super(naam, scanner,++lidCounter, wachtwoord);
    }

    @Override
    public void showMenu(Bibliotheek bib) {

    }

    @Override
    public User maakUserAan(Bibliotheek bib) {
        return null;
    }

//    @Override
//    public asbtract User maakUserAan(Bibliotheek bib) {
//
//    }
}
