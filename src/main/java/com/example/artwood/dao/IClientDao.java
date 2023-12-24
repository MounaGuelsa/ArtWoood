package com.example.artwood.dao;

import com.example.artwood.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientDao {
    Client ajouterClient(Client c) throws SQLException;
    List<Client> listeClients();
    Client rechercherClient(int id);
    void modifierClient(Client c);
    void supprimerClient(int id);
}
