package be.vives.ti.ui;

import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public class Clerk extends User {

    public Clerk(String naam, Scanner scanner) {
        super(naam, scanner);
    }

    @Override
    public void showMenu(Bibliotheek bib) {
        int keuze = 0;
        while(keuze ==0) {
            System.out.println("--Menu van " + super.getNaam() + "--");
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
                showMenu(bib);
            } else if(keuze == 2){
                voegBoekToe(bib);
            } else if(keuze == 3){
                verwijderBoek(bib);
            } else if(keuze == 4){
                zoekBoek(bib);
            }
        }
    }

    private void verwijderBoek(Bibliotheek bib) {
        System.out.println("Gelieve een isbn nummer in te geven");
        String isbn = scanner.nextLine();
        bib.verwijderBoekViaISBN(isbn);
        showMenu(bib);
    }


    private void voegBoekToe(Bibliotheek bib) {
        System.out.println("Gelieve een isbn nummer in te geven");
        String isbn = scanner.nextLine();
        bib.addBoekViaIsbn(isbn);
        showMenu(bib);
    }

    private void zoekBoek(Bibliotheek bib){
        System.out.println("Gelieve een isbn nummer in te geven");
        String isbn = scanner.nextLine();
        System.out.println(bib.getDetailsVanBoek(isbn));
        showMenu(bib);
    }
}
