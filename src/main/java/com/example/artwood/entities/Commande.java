package com.example.artwood.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


public class Commande implements Serializable {
    private String ref_cmd;
    private String description;
    private Date date_cmd;
    private Status status;
    private double total;

    public String getRef_cmd() {
        return ref_cmd;
    }

    public void setRef_cmd(String ref_cmd) {
        this.ref_cmd = ref_cmd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_cmd() {
        return date_cmd;
    }

    public void setDate_cmd(Date date_cmd) {
        this.date_cmd = date_cmd;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Map<Produit, Integer> getListeProduits() {
        return listeProduits;
    }

    public void setListeProduits(Map<Produit, Integer> listeProduits) {
        this.listeProduits = listeProduits;
    }

    Map<Produit, Integer> listeProduits;

    public Commande(String ref_cmd, String description, Date date_cmd, Status status, double total, Map<Produit, Integer> listeProduits) {
        this.ref_cmd = ref_cmd;
        this.description = description;
        this.date_cmd = date_cmd;
        this.status = status;
        this.total = total;
        this.listeProduits = listeProduits;
    }

    public Commande() {
    }

    @Override
    public String toString() {
        return "Commande{" +
                "ref_cmd='" + ref_cmd + '\'' +
                ", description='" + description + '\'' +
                ", date_cmd=" + date_cmd +
                ", status=" + status +
                ", total=" + total +
                ", listeProduits=" + listeProduits +
                '}';
    }
}
