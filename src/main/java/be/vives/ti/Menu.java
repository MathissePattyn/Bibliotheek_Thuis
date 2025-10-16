package be.vives.ti;

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
                System.out.println("U wordt aangemeld als Clerk");
                user = new Clerk("TestClerk1");
                user.showMenu(bib, scanner);
            } else if(keuze == 2){

            } else if(keuze == 3) {

            }else {
                System.out.println("Gelieve een geldige keuze te maken");
                inlogMenu();
            }
        }
    }

    public void keuzeLidOfClerk() {

    }

    private void keuzeMenuClerk() {
    }

    private void keuzeMenuLid() {
    }
}
