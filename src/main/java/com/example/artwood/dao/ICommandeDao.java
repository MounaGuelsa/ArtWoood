package com.example.artwood.dao;

import com.example.artwood.entities.Commande;

import java.sql.SQLException;
import java.util.List;

public interface ICommandeDao {
    Commande ajouterCommande(Commande commande) throws SQLException;
    List<Commande> listeCommandes();
    Commande rechercherCommande(String ref_cmd);
    void modifierCommande(Commande commande);
    void supprimerCommande(String ref_cmd);
}
