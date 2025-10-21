package be.vives.ti.ui;

import be.vives.ti.model.Clerk;
import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.util.ArrayList;
import java.util.Scanner;

public class ClerkMenu extends UserMenu{
    public ClerkMenu(Clerk clerk, Bibliotheek bib) {
        super(clerk, bib);
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Keuze menu van de Clerk--");
        int keuze = 0;
        int idKeuzes = 1;
        ArrayList<Clerk> winkelbedienden = bib.getWinkelBedienden();
        if(winkelbedienden.size()==0) {
            System.out.println("1. Gebruiker Aanmaken");
            System.out.println("2. Vorige menu");
            System.out.println("3. Afsluiten");
            keuze = scanner.nextInt();
        } else{
            for (int i = 0; i < winkelbedienden.size(); i++) {
                System.out.println(idKeuzes + ". " + winkelbedienden.get(i).getNaam());
                idKeuzes++;
            }
            System.out.println(idKeuzes + ". Vorige menu");
            idKeuzes++;
            System.out.println(idKeuzes + ". Afsluiten");
            keuze = scanner.nextInt();
        }
    }
    }
}
