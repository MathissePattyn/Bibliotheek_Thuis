package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.User;

import java.util.Scanner;

public class Lid extends User {
    private int lidNummer;

    public Lid(int lidNummer, String naam, Scanner scanner) {
        super(naam, scanner);
        this.lidNummer = lidNummer;
    }

    @Override
    public void showMenu(Bibliotheek bib) {

    }
}
