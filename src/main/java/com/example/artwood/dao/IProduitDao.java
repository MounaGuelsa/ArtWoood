package com.example.artwood.dao;

import com.example.artwood.entities.Produit;


import java.sql.SQLException;
import java.util.List;

public interface IProduitDao {
    Produit ajouterProduit(Produit p) throws SQLException;
    List<Produit> listeProduits();
    Produit rechercherProduit(int id);
    void modifierProduit(Produit p);
    void supprimerProduit(int id);
}

