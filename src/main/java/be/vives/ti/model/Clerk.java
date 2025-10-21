package be.vives.ti.model;

import be.vives.ti.service.Bibliotheek;
import be.vives.ti.ui.ClerkMenu;

import java.util.Scanner;

public class Clerk extends User {

    private static int clerkCounter = 0;
    public Clerk(String naam, String wachtwoord) {
        super(naam, ++clerkCounter, wachtwoord);
    }

//    @Override
//    public void showMenu(Bibliotheek bib) {
////        new ClerkMenu(this, bib).showMenu();
//        int keuze = 0;
//        while(keuze ==0) {
//            System.out.println("--Menu van " + super.getNaam() + "--");
//            System.out.println("1. Toon alle aanwezige boeken");
//            System.out.println("2. Voeg een boek toe obv isbn");
//            System.out.println("3. Verwijder een boek obv isbn");
//            System.out.println("4. Zoek een boek obv isbn");
//            System.out.println("5. Vorige menu");
//            System.out.println("6. Afsluiten");
//            keuze = scanner.nextInt();
//            scanner.nextLine();
//
//            if (keuze == 1){
//                System.out.println(bib.getDetailsLijstVanBoeken());
//                showMenu(bib);
//            } else if(keuze == 2){
//                voegBoekToe(bib);
//            } else if(keuze == 3){
//                verwijderBoek(bib);
//            } else if(keuze == 4){
//                zoekBoek(bib);
//            }
//        }
//    }
//
//    @Override
//    public User maakUserAan(Bibliotheek bib) {
//        System.out.println("Gelieve een GebruikersNaam in te geven: ");
//        String naam = scanner.nextLine();
//        System.out.println("Gelieve een wachtwoord in te geven");
//        String wachtwoord = scanner.nextLine();
//        if(!naam.isBlank() && !wachtwoord.isBlank()) {
//            return new Clerk(naam,wachtwoord);
//        } else{
//            System.out.println("Gelieve geldige gebruikersnaam en wachtwoord in te geven, probeer opnieuw");
//            maakUserAan(bib);
//        }
//        return null;
//    }

//
//    protected void verwijderBoek(Bibliotheek bib) {
//        System.out.println("Gelieve een isbn nummer in te geven");
//        String isbn = scanner.nextLine();
//        bib.verwijderBoekViaISBN(isbn);
//        showMenu(bib);
//    }
//
//
//    protected void voegBoekToe(Bibliotheek bib) {
//        System.out.println("Gelieve een isbn nummer in te geven");
//        String isbn = scanner.nextLine();
//        bib.addBoekViaIsbn(isbn);
//        showMenu(bib);
//    }
//
//    protected void zoekBoek(Bibliotheek bib){
//        System.out.println("Gelieve een isbn nummer in te geven");
//        String isbn = scanner.nextLine();
//        System.out.println(bib.getDetailsVanBoek(isbn));
//        showMenu(bib);
//    }
}
