package be.vives.ti;

import java.util.Scanner;

public class Clerk extends User{

    public Clerk(String naam) {
        super(naam);
    }



    @Override
    public void showMenu(Bibliotheek bib, Scanner scanner) {
        System.out.println("--Menu van " + super.getNaam() + "--");
    }
}
