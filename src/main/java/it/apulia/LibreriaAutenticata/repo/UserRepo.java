package it.apulia.LibreriaAutenticata.repo;

import it.apulia.LibreriaAutenticata.model.Utente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<Utente,String> {
    Utente findUtenteByUsername(String username);
    Boolean existsByUsername(String username);

}
