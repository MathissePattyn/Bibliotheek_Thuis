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
        System.out.println("Welkom in de bib");
        User user = null;
        int keuze = 0;
        while(user == null){
            System.out.println("--Gelieve aan te melden--");
            System.out.println("1. Clerk");
            System.out.println("2. Lid");
            System.out.println("3. Afsluiten");
            keuze = scanner.nextInt();
            scanner.nextLine();
            if(keuze == 1){
                System.out.println("U wordt aangemeld als Clerk");
                user = new Clerk("TestClerk1");
                user.showMenu(bib, scanner);
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
