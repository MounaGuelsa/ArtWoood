package com.example.artwood.dao;

import com.example.artwood.entities.Commande;

import java.sql.SQLException;
import java.util.List;

public class CommandeDaoImp implements ICommandeDao{

    @Override
    public Commande ajouterCommande(Commande commande) throws SQLException {
        return null;
    }

    @Override
    public List<Commande> listeCommandes() {
        return null;
    }

    @Override
    public Commande rechercherCommande(String ref_cmd) {
        return null;
    }

    @Override
    public void modifierCommande(Commande commande) {

    }

    @Override
    public void supprimerCommande(String ref_cmd) {

    }
}
