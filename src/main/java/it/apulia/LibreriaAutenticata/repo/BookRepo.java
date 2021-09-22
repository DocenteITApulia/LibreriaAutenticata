package it.apulia.LibreriaAutenticata.repo;

import it.apulia.LibreriaAutenticata.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends MongoRepository<Libro, String> {
    @Query("{ 'autore' : ?0 }")
    List<Libro> findLibriByAutore(String autore);

    @Query("{ 'anno' : ?0 }")
    List<Libro> findLibriByAnno(Integer anno);

    Libro findLibroByAutoreAndTitolo(String autore, String titolo);
}
