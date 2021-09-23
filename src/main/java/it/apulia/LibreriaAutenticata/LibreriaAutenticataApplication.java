package it.apulia.LibreriaAutenticata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibreriaAutenticataApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaAutenticataApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//link per gestione errori rest, compreso pagina personale accesso negato
	// https://www.baeldung.com/exception-handling-for-rest-with-spring

}
