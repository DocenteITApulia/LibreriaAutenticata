package it.apulia.LibreriaAutenticata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "utenti")
@Data //annotazione di lombok per la creazione automatica di getter e setter
@NoArgsConstructor //indica la creazione del costruttore senza parametri
@AllArgsConstructor //indica la creazione del costruttore con un parametro per ogni campo
public class Utente {
    @Id
    private String id;
    private String nome;
    @Indexed
    private String username; //noi metteremo l'email
    private String password;
//in questo caso abbiamo meno parametri, ma come compito adatteremo poi il nostro progetto a questo

    //Questa annotazione, oltre ad indicare una relazioni molti a molti tra utenti e ruoli, indica la volontà da parte nostra
    //che durante il caricamento i dati dei ruoli vengano caricati in contemporanea e non su richiesta (LAZY)
  //  @DBRef
    private Collection<Role> roles = new ArrayList<Role>();

}
