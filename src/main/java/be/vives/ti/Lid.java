package be.vives.ti;

import java.util.ArrayList;
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
