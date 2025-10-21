package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.ClerkMenu;

import java.util.Scanner;

public class Clerk extends User {

    private static int clerkCounter = 0;
    public Clerk(String naam, String wachtwoord) {
        super(naam, ++clerkCounter, wachtwoord);
    }
}
