package be.vives.ti;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.Menu;

public class Main {
    static void main() {
        Bibliotheek bib = new Bibliotheek();
        Menu menu = new Menu(bib);

        menu.Start();
    }
}
