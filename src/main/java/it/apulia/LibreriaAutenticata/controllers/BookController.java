package it.apulia.LibreriaAutenticata.controllers;

import it.apulia.LibreriaAutenticata.model.Libro;
import it.apulia.LibreriaAutenticata.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//TODO implementare check e relative risposte in caso di errori
@RestController
@Slf4j
@RequestMapping("/libreria")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping
    ResponseEntity<List<Libro>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @PostMapping
    ResponseEntity<Libro> saveBook(@RequestBody Libro libro){
        bookService.saveLibro(libro);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/libreria/" + libro.getIsbn()).toUriString());

        log.info("Libro {} salvato all'interno della libreria raggiungibile al link {} ",libro.getTitolo(), uri.toString());
        return ResponseEntity.created(uri).body(libro);
    }

    @GetMapping("/{isbn}")
    ResponseEntity<Libro> getLibro(@PathVariable String isbn) {
        return ResponseEntity.ok().body(bookService.getBookByISBN(isbn));
    }

    //TODO gestire manualmente update
    @PutMapping("/{isbn}")
    ResponseEntity<?> updateLibro(@PathVariable String isbn, @RequestBody Libro libro){
        bookService.updateLibro(libro);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{isbn}")
    ResponseEntity<?> deleteLibro(@PathVariable String isbn){
        bookService.deleteLibro(isbn);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/anno/{anno}")
    ResponseEntity<List<Libro>> getAllBooksByAnno(@PathVariable Integer anno) {
        return ResponseEntity.ok().body(bookService.getLibriByAnno(anno));
    }

    @GetMapping("/autore/{autore}")
    ResponseEntity<List<Libro>> getAllBooksByAutore(@PathVariable String autore) {
        return ResponseEntity.ok().body(bookService.getLibriByAutore(autore));
    }

    @GetMapping("/ricerca")
    ResponseEntity<Libro> findBooks(@RequestParam String autore, @RequestParam String titolo){
        return ResponseEntity.ok().body(bookService.getLibro(autore,titolo));
    }

}
