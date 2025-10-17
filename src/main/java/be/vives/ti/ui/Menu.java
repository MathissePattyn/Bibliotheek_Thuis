package be.vives.ti.ui;

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

    public void Start(){
        inlogMenu();
    }

    public void inlogMenu(){
        System.out.println("Welkom in de bib");
        User user = null;
        int keuze = 0;

        //Keuze menu (User of Lid)
        while(user == null){
            System.out.println("--Gelieve aan te melden--");
            System.out.println("1. Clerk");
            System.out.println("2. Lid");
            System.out.println("3. Afsluiten");
            keuze = scanner.nextInt();
            scanner.nextLine();

            //Code voor keuze
            if(keuze == 1){
                keuzeMenuClerk();
                keuze = scanner.nextInt();


            } else if(keuze == 2){

            } else if(keuze == 3) {

            }else {
                System.out.println("Gelieve een geldige keuze te maken" + "\n");
                inlogMenu();
            }
        }
    }

    public void keuzeLidOfClerk() {

    }

    private void keuzeMenuClerk() {
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

    public void keuzeMenuLid() {
    }

    public Clerk maakEenClerkAan(){

    }
}
