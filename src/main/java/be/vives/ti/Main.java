package be.vives.ti;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.Menu;

public class Main {
    public static void main(String[] args) {
        Bibliotheek bib = new Bibliotheek();
        Menu menu = new Menu(bib);
        menu.Start(); // lowercase conventie
    }
}

