package be.vives.ti;

import java.util.ArrayList;
import java.util.Scanner;

public class Lid extends User {
    private int lidNummer;

    public Lid(int lidNummer, String naam) {
        super(naam);
        this.lidNummer = lidNummer;
    }

    @Override
    public void showMenu(Bibliotheek bib, Scanner scanner) {

    }
}
