package be.vives.ti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BibliotheekTest {
    private Bibliotheek bib;

    @BeforeEach
    void setUp() {
        bib = new Bibliotheek();
    }

    @Test
    void addBoekViaIsbn() {
        bib.addBoekViaIsbn("9780747532743");
        ArrayList<Boek> boeken = bib.getBoeken();
        assertThat(boeken.size()).isEqualTo(1);
        assertThat(boeken.getFirst().getISBN()).isEqualTo("9780747532743");
    }

    @Test
    void verwijderBoekViaISBN() {
        bib.addBoekViaIsbn("9780747532743");
        ArrayList<Boek> boeken = bib.getBoeken();
        assertThat(boeken).isNotNull();
        assertThat(boeken.getFirst().getISBN()).isEqualTo("9780747532743");

        bib.verwijderBoekViaISBN("9780747532743");
        assertThat(boeken.size()).isEqualTo(0);
    }
}