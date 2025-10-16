package be.vives.ti;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OpenLibraryServiceTest {

    @Test
    void haalEenBoekOpViaEenISBN(){
        String Isbn = "9780747532743";
        Boek boekJson = OpenLibraryService.haalBoekOpViaISBN(Isbn);
        assertThat(boekJson).isNotNull();

        assertThat(boekJson.getISBN()).isEqualTo("9780747532743");
        assertThat(boekJson.getTitel()).isEqualTo("Harry Potter and the Philosopher's Stone");
        assertThat(boekJson.getAuteur()).contains("J. K. Rowling");

    }
}