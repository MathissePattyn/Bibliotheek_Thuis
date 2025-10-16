package be.vives.ti;

import be.vives.ti.model.Boek;
import be.vives.ti.service.Bibliotheek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class BibliotheekTest {
    private Bibliotheek bib;

    @BeforeEach
    void setUp() {
        bib = new Bibliotheek();
    }

    @Test
    void addBoekViaBestaandIsbn() {
        bib.addBoekViaIsbn("9780747532743"); // Harry Potter 1
        ArrayList<Boek> boeken = bib.getBoeken();
        assertThat(boeken.size()).isEqualTo(1);
        assertThat(boeken.get(0).getISBN()).isEqualTo("9780747532743");
        assertThat(boeken.get(0).getTitel()).isNotEmpty();
    }

    //IS TESTEN OP TOEVOEGEN OP ONBESTAAND ISBN NOG NODIG ALS IK DIT AL GETEST HEB IN OPENLIBRARY?

    @Test
    void addMeerdereBoeken() {
        String[] isbnLijst = {
                "9780747532743", // Harry Potter 1
                "9780743273565", // The Great Gatsby
        };

        // Voeg elk boek toe
        for (String isbn : isbnLijst) {
            bib.addBoekViaIsbn(isbn);
        }

        // Haal de boekenlijst op
        ArrayList<Boek> boeken = bib.getBoeken();

        // Controleer dat alle boeken toegevoegd zijn
        assertThat(boeken.size()).isEqualTo(isbnLijst.length);

        // Controleer dat elk boek het juiste ISBN heeft en een titel
        for (int i = 0; i < isbnLijst.length; i++) {
            assertThat(boeken.get(i).getISBN()).isEqualTo(isbnLijst[i]);
            assertThat(boeken.get(i).getTitel()).isNotEmpty();
            assertThat(boeken.get(i).getAuteur()).isNotEmpty();
        }
    }


    @Test
    void addDubbelBoekNietToegvoegd() {
        bib.addBoekViaIsbn("9780747532743");
        bib.addBoekViaIsbn("9780747532743"); // zelfde ISBN opnieuw
        ArrayList<Boek> boeken = bib.getBoeken();

        assertThat(boeken.size()).isEqualTo(1); // mag niet verdubbelen
    }

    @Test
    void verwijderBoekViaISBN() {
        bib.addBoekViaIsbn("9780747532743");
        ArrayList<Boek> boeken = bib.getBoeken();
        assertThat(boeken).isNotNull();
        assertThat(boeken.get(0).getISBN()).isEqualTo("9780747532743");

        bib.verwijderBoekViaISBN("9780747532743");
        assertThat(boeken.size()).isEqualTo(0);
    }

    @Test
    void addEnVerwijderMeerdereBoeken() {
        // Stap 1: Voeg meerdere boeken toe
        String[] isbnLijst = {
                "9780747532743", // Harry Potter 1
                "9780743273565", // The Great Gatsby
                "9780451524935"  // 1984
        };

        for (String isbn : isbnLijst) {
            bib.addBoekViaIsbn(isbn);
        }

        ArrayList<Boek> boeken = bib.getBoeken();
        assertThat(boeken.size()).isEqualTo(isbnLijst.length);

        // Controleer dat elk boek aanwezig is
        for (String isbn : isbnLijst) {
            assertThat(boeken.stream().anyMatch(b -> b.getISBN().equals(isbn))).isTrue();
        }

        // Stap 2: Verwijder een boek
        bib.verwijderBoekViaISBN("9780743273565"); // The Great Gatsby

        boeken = bib.getBoeken();
        assertThat(boeken.size()).isEqualTo(2);
        assertThat(boeken.stream().anyMatch(b -> b.getISBN().equals("9780743273565"))).isFalse();

        // Stap 3: Controleer de overgebleven boeken
        assertThat(boeken.stream().anyMatch(b -> b.getISBN().equals("9780747532743"))).isTrue();
        assertThat(boeken.stream().anyMatch(b -> b.getISBN().equals("9780451524935"))).isTrue();

        // Stap 4: Voeg nog een boek toe
        bib.addBoekViaIsbn("9780140449136"); // The Odyssey
        boeken = bib.getBoeken();
        assertThat(boeken.size()).isEqualTo(3);
        assertThat(boeken.stream().anyMatch(b -> b.getISBN().equals("9780140449136"))).isTrue();
    }

    @Test
    void verwijderNietBestaandBoekInDeBib() {
        bib.verwijderBoekViaISBN("1234567890"); // ISBN bestaat niet
        ArrayList<Boek> boeken = bib.getBoeken();
        assertThat(boeken.size()).isEqualTo(0); // lijst blijft leeg
    }

    @Test
    void getDetailsVanBoekInDeBib() {
        bib.addBoekViaIsbn("9780747532743");
        String details = bib.getDetailsVanBoek("9780747532743");
        assertThat(details).contains("Harry Potter"); // titel zou in details moeten staan
    }

    @Test
    void getDetailsOnbestaandBoekInDeBib(){
        String nietBestaand = bib.getDetailsVanBoek("1234567890");
        assertThat(nietBestaand).isEqualTo("Boek niet gevonden\n");
    }

    @Test
    void getDetailsLijstVanBoeken() {
        bib.addBoekViaIsbn("9780747532743");
        bib.addBoekViaIsbn("9780743273565");

        String lijst = bib.getDetailsLijstVanBoeken();
        assertThat(lijst).contains("9780747532743");
        assertThat(lijst).contains("9780743273565");
    }
}