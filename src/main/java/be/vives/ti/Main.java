package be.vives.ti;

public class Main {
    static void main() {
        Bibliotheek bib = new Bibliotheek();
        Menu menu = new Menu(bib);

        menu.Start();
    }
}
