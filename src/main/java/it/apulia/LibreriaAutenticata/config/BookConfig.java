package it.apulia.LibreriaAutenticata.config;

import it.apulia.LibreriaAutenticata.model.Libro;
import it.apulia.LibreriaAutenticata.model.Role;
import it.apulia.LibreriaAutenticata.model.Utente;
import it.apulia.LibreriaAutenticata.repo.BookRepo;
import it.apulia.LibreriaAutenticata.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepo repository, UserService userService) {
        return args -> {
            userService.resetAll();
            /*
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
*/

            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_MANAGER"));
            userService.saveRole(new Role("ROLE_ADMIN"));
            userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

            userService.saveUtente(new Utente(null, "John Travolta", "john", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente(null, "Will Smith", "will", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

            userService.addRoleToUtente("john", "ROLE_USER");
            userService.addRoleToUtente("will", "ROLE_MANAGER");
            userService.addRoleToUtente("jim", "ROLE_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_SUPER_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_USER");

            Libro libro1 = new Libro("IT123QWE","It","S.King",1993, "linkamazon");
            List<String> temp2 = new ArrayList<String>();
            temp2.add("Horror");
            temp2.add("Thriller");
            Libro libro2 = new Libro("IT123ASD","Shining","S.King",1991, "linkamazon",temp2);

            List<Libro> temp= new ArrayList<>();
            temp.add(libro1);
            temp.add(libro2);


            repository.deleteAll();

            repository.saveAll(
                    temp
            );
        };

    }
}
