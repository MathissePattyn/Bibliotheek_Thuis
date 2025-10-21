package be.vives.ti.ui;

import be.vives.ti.model.Clerk;
import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Bibliotheek bib;

    public Menu(Bibliotheek bib) {
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
                Clerk clerk = kiesOfMaakClerk();
                ClerkMenu clerkMenu = new ClerkMenu(clerk, bib, scanner);
                clerkMenu.showMenu();

            } else if (keuze == 2) {

            } else if (keuze == 3) {

            } else {
                System.out.println("Gelieve een geldige keuze te maken" + "\n");
                inlogMenu();
            }
        }
    }

    public Clerk kiesOfMaakClerk() {
        System.out.println("--Keuze menu van de Clerk--");
        int keuze = 0;
        int idKeuzes = 1;
        ArrayList<Clerk> winkelbedienden = bib.getWinkelBedienden();
        if (winkelbedienden.size() == 0) {
            System.out.println("Nog geen winkelbedienden aanwezig. Nieuw account wordt aangemaakt");
            return maakClerkAan();
        } else {
            int id = 1;
            for (int i = 0; i < winkelbedienden.size(); i++) {
                System.out.println(idKeuzes + ". " + winkelbedienden.get(i).getNaam());
                idKeuzes++;
            }
            System.out.println(id + ". Nieuwe gebruiker aanmaken");
            id++;
            System.out.println(id + ". Vorige menu");
            id++;
            System.out.println(id + ". Afsluiten");
            keuze = scanner.nextInt();

            if (keuze > 0 && keuze <= winkelbedienden.size()) {
                return winkelbedienden.get(keuze - 1);
            } else if (keuze == winkelbedienden.size() + 1) {
                return maakClerkAan();
            } else {
                return null;
            }
        }
    }

    private Clerk maakClerkAan() {
        System.out.println("--Gelieve een gebruikersnaam in te geven--");
        String naam = scanner.nextLine();
        System.out.println("Gelieve een wachtwoord in te geven");
        String wachtwoord = scanner.nextLine();
        if (!naam.isBlank() && !wachtwoord.isBlank()) {
            Clerk clerk = new Clerk(naam, wachtwoord);
            return clerk;
        } else {
            System.out.println("Gelieve iets in te vullen, probeer opnieuw");
            maakClerkAan();
        }
        return null;
    }

}


