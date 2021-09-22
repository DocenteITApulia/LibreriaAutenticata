package it.apulia.LibreriaAutenticata.repo;

import it.apulia.LibreriaAutenticata.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role,String> {
    Role findByNome(String nome);
}
