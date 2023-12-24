package com.example.artwood.entities;


import java.io.Serializable;

public class Produit implements Serializable {
    private int id_prduit;
    private String designation;
    private double prix_unit;
    private int quantite;

    public int getId_prduit() {
        return id_prduit;
    }

    public Produit(int id_prduit, String designation, double prix_unit, int quantite) {
        this.id_prduit = id_prduit;
        this.designation = designation;
        this.prix_unit = prix_unit;
        this.quantite = quantite;
    }

    public Produit() {
    }

    public void setId_prduit(int id_prduit) {
        this.id_prduit = id_prduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix_unit() {
        return prix_unit;
    }

    public void setPrix_unit(double prix_unit) {
        this.prix_unit = prix_unit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

