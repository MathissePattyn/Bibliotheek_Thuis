package be.vives.ti.ui;

import be.vives.ti.model.Clerk;
import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.util.ArrayList;
import java.util.Scanner;

public class ClerkMenu extends UserMenu{
    public ClerkMenu(Clerk clerk, Bibliotheek bib, Scanner scanner) {
        super(clerk, bib, scanner);
    }

    @Override
    public void showMenu() {
        int keuze = 0;
        while(keuze ==0) {
            System.out.println("--Menu van " + super.getUser().getNaam() + "--");
            System.out.println("1. Toon alle aanwezige boeken");
            System.out.println("2. Voeg een boek toe obv isbn");
            System.out.println("3. Verwijder een boek obv isbn");
            System.out.println("4. Zoek een boek obv isbn");
            System.out.println("5. Vorige menu");
            System.out.println("6. Afsluiten");
            keuze = scanner.nextInt();
            scanner.nextLine();



            if (keuze == 1){
                System.out.println(bib.getDetailsLijstVanBoeken());
                showMenu();
            } else if(keuze == 2){
                System.out.println("Gelieve een isbn in te geven");
                String isbn = scanner.nextLine();
                bib.addBoekViaIsbn(isbn);
                showMenu();
            } else if(keuze == 3){
//                verwijderBoek(bib);
            } else if(keuze == 4){
//                zoekBoek(bib);
            }
        }
    }
}
