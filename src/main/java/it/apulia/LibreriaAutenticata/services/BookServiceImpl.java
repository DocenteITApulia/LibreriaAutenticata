package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Libro;
import it.apulia.LibreriaAutenticata.repo.BookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService{
    private final BookRepo bookRepository;

    @Autowired
    public BookServiceImpl(BookRepo bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Libro> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Libro> getLibriByAnno(Integer anno) {
        return this.bookRepository.findLibriByAnno(anno);
    }

    @Override
    public Libro getBookByISBN(String isbn) {

        Libro temp = bookRepository.findById(isbn).get();

        return bookRepository.findById(isbn).get();
    }

    @Override
    public List<Libro> getLibriByAutore(String autore) {
        return bookRepository.findLibriByAutore(autore);
    }


    @Override
    public Libro getLibro(String autore, String titolo) {
        return bookRepository.findLibroByAutoreAndTitolo(autore,titolo);
    }

    @Override
    public void saveLibro(Libro libro) {
        bookRepository.save(libro);
    }

    @Override
    public void updateLibro(Libro libro) {
        if(this.getBookByISBN(libro.getIsbn()).equals(libro))
            bookRepository.save(libro);
        else
            log.error("Libro da aggiornare {} non presente all'interno del db", libro.getTitolo());
    }

    @Override
    public void deleteLibro(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
