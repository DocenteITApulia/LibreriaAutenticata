package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Role;
import it.apulia.LibreriaAutenticata.model.Utente;

import java.util.List;

public interface UserService {
    Utente saveUtente(Utente utente);
    Role saveRole(Role role);
    void addRoleToUtente(String username, String roleName);
    Utente getUtente(String username);
    List<Utente> getUtenti();
    void resetAll();
}
