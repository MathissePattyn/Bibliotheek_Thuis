package be.vives.ti;

import be.vives.ti.exceptions.BoekNietGevondenException;
import be.vives.ti.model.Boek;
import be.vives.ti.service.OpenLibraryService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OpenLibraryServiceTest {

    @Test
    void haalEenBoekOpViaEenBestaandISBN() throws BoekNietGevondenException {
        String Isbn = "9780747532743";
        Boek boekJson = OpenLibraryService.haalBoekOpViaISBN(Isbn);
        assertThat(boekJson).isNotNull();

        assertThat(boekJson.getISBN()).isEqualTo("9780747532743");
        assertThat(boekJson.getTitel()).isEqualTo("Harry Potter and the Philosopher's Stone");
        assertThat(boekJson.getAuteur()).contains("J. K. Rowling");

    }

    @Test
    void haalEenBoekOpVanEenNietBestaandISBN(){
        String Isbn = "0000000000000";
        assertThatThrownBy(() ->OpenLibraryService.haalBoekOpViaISBN(Isbn))
                .isInstanceOf(BoekNietGevondenException.class)
                .hasMessageContaining("ISBN niet gevonden: 0000000000000");
    }
}