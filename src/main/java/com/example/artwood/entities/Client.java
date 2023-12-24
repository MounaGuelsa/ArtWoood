package com.example.artwood.entities;


import java.io.Serializable;

public class Client implements Serializable {
    private int id_client;
    private String nom_client;
    private String prenom_client;
    private String adresse;

    public int getId_client() {
        return id_client;
    }

    public Client() {
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{" +
                "user_id='" + id_client + '\'' +
                ", nom_user='" + nom_client + '\'' +
                ", prenom_user='" + prenom_client + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
