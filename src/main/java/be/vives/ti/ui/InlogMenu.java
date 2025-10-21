package be.vives.ti.ui;

import be.vives.ti.model.Clerk;
import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.util.ArrayList;
import java.util.Scanner;

public class InlogMenu {
    private Scanner scanner;
    private Bibliotheek bib;

    public InlogMenu(Bibliotheek bib) {
        this.bib = bib;
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        inlogMenu();
    }

    public void inlogMenu() {
        System.out.println("Welkom in de bib");
        User user = null;
        int keuze = 0;

        //Keuze menu (User of Lid)
        while (user == null) {
            System.out.println("--Gelieve aan te melden--");
            System.out.println("1. Clerk");
            System.out.println("2. Lid");
            System.out.println("3. Afsluiten");
            keuze = scanner.nextInt();
            scanner.nextLine();

            //Code voor keuze
            if (keuze == 1) {
                user = kiesOfMaakClerk();
                if(user != null){
                    ClerkMenu clerkMenu = new ClerkMenu((Clerk) user, bib, scanner);
                    clerkMenu.showMenu();
                }
            } else if (keuze == 2) {

            } else if (keuze == 3) {
                System.exit(0);
            } else {
                System.out.println("Gelieve een geldige keuze te maken" + "\n");
                inlogMenu();
            }
        }
    }

    public Clerk kiesOfMaakClerk() {
        System.out.println("--Keuze menu van de Clerk--");
        ArrayList<Clerk> winkelbedienden = bib.getWinkelBedienden();
        int keuze;

        if (winkelbedienden.isEmpty()) {
            System.out.println("Nog geen winkelbedienden aanwezig. \nNieuw account wordt aangemaakt");
            return maakClerkAan();
        } else {
            while (true) { // loop totdat een geldige keuze is gemaakt
                int id = 1;
                for (Clerk c : winkelbedienden) {
                    System.out.println(id++ + ". " + c.getNaam());
                }
                System.out.println(id++ + ". Nieuwe gebruiker aanmaken");
                System.out.println(id++ + ". Vorige menu");
                System.out.println(id++ + ". Afsluiten");

                keuze = scanner.nextInt();
                scanner.nextLine(); // buffer leegmaken

                if (keuze > 0 && keuze <= winkelbedienden.size()) {
                    return winkelbedienden.get(keuze - 1);
                } else if (keuze == winkelbedienden.size() + 1) {
                    return maakClerkAan();
                } else if (keuze == winkelbedienden.size() + 2) {
                    return null; // Vorige menu
                } else if (keuze == winkelbedienden.size() + 3) {
                    System.exit(0);
                } else {
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
                }
            }
        }
    }


    public Clerk maakClerkAan() {
        while (true) {
            System.out.println("--Gelieve een gebruikersnaam in te geven--");
            String naam = scanner.nextLine();
            System.out.println("Gelieve een wachtwoord in te geven");
            String wachtwoord = scanner.nextLine();
            if (!naam.isBlank() && !wachtwoord.isBlank()) {
                Clerk clerk = new Clerk(naam, wachtwoord);
                bib.addClerk(clerk);
                return clerk;
            } else {
                System.out.println("Gelieve iets in te vullen, probeer opnieuw");
            }
        }
    }

}


