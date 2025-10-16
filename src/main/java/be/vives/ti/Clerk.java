package be.vives.ti;

import java.util.Scanner;

public class Clerk extends User{

    public Clerk(String naam) {
        super(naam);
    }

    @Override
    public void showMenu(Bibliotheek bib, Scanner scanner) {
        int keuze = 0;
        while(keuze ==0) {
            System.out.println("--Menu van " + super.getNaam() + "--");
            System.out.println("1. Toon alle aanwezige boeken");
            System.out.println("2. Voeg een boek toe adhv ISBN");
            System.out.println("3. Verwijder een boek adhv ISBN");
            System.out.println("4. Vorige menu");
            System.out.println("5. Afsluiten");
            keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1){
                System.out.println(bib.getBoeken());
            } else if(keuze == 2){
                voegBoekToe(bib, scanner);
            }
        }
    }


    private void voegBoekToe(Bibliotheek bib, Scanner scanner) {
        System.out.println("Gelieve een isbn nummer in te geven");
        String isbn = scanner.nextLine();
        bib.addBoekViaIsbn(isbn);
        showMenu(bib, scanner);
    }
}
