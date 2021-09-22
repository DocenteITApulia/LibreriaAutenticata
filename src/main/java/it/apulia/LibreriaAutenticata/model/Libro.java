package it.apulia.LibreriaAutenticata.model;

import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "bookLibrary")
@Data
public class Libro {
    @Id
    String isbn;
    String titolo;
    @Indexed
    String autore;
    Integer anno;
    String link;

    List<String> generi;

    public Libro(String isbn, String titolo, String autore, Integer anno, String link, List<String> generi) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.link = link;
        this.generi = generi;
    }

    public Libro(String isbn, String titolo, String autore, Integer anno, String link) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.link = link;
    }

    public Libro() {
    }
}
