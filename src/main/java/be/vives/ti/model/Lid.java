package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.User;

import java.util.Scanner;

public class Lid extends User {
    private static int lidCounter = 0;

    public Lid(String naam, Scanner scanner) {
        super(naam, scanner,++lidCounter);
    }

    @Override
    public void showMenu(Bibliotheek bib) {

    }

    @Override
    public void maakUserAan() {

    }
}
