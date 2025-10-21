package be.vives.ti;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.InlogMenu;

public class Main {
    public static void main(String[] args) {
        Bibliotheek bib = new Bibliotheek();
        InlogMenu inlogMenu = new InlogMenu(bib);
        inlogMenu.Start();
    }
}

