package com.example.artwood.dao;




import com.example.artwood.entities.Produit;
import com.example.artwood.outils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImp implements IProduitDao {
    Connection connection = ConnectionDB.getConnectionDB();
    ////private static final Logger logger = LogManager.getLogger(ProduitDaoImp.class);

    @Override
    public Produit ajouterProduit(Produit p) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into produit (designation,prix_unit,quantite) Values(?,?,?)");
            preparedStatement.setString(1, p.getDesignation());
            preparedStatement.setDouble(2, p.getPrix_unit());
            preparedStatement.setInt(3, p.getQuantite());
            preparedStatement.executeUpdate();
            PreparedStatement ps = connection.prepareStatement("select max(id_produit) as maxid from produit");
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                p.setId_prduit(resultSet.getInt("MAX_id"));
                //logger.info("le produit est bien ajouté");

            }
            preparedStatement.close();
        } catch (SQLException e) {
            //logger.error("Erreur lors de l'ajout d'un produit", e);
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Produit> listeProduits() {
        ArrayList<Produit> listeProduit = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from produit");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId_prduit(rs.getInt("id_produit"));
                produit.setDesignation(rs.getString("designation"));
                produit.setPrix_unit(rs.getDouble("prix_unit"));
                produit.setQuantite(rs.getInt("quantite"));
                listeProduit.add(produit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProduit;
    }

    @Override
    public Produit rechercherProduit(int id) {
        Produit p = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUIT where id_produit = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId_prduit(rs.getInt("id_produit"));
                p.setDesignation(rs.getString("designation"));
                p.setPrix_unit(rs.getDouble("prix_unit"));
                p.setQuantite(rs.getInt("quantite"));
            }


            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        if (p == null) throw new RuntimeException("Produit " + id + " est introuvable");
        return p;

    }

    @Override
    public void modifierProduit(Produit p) {
        try {
            PreparedStatement ps = connection.prepareStatement("update produit set designation = ?, prix_unit = ?, quantite = ? where id_produit = ?");
            ps.setString(1, p.getDesignation());
            ps.setDouble(2, p.getPrix_unit());
            ps.setInt(3, p.getQuantite());
            ps.setInt(4, p.getId_prduit());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerProduit(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete FROM produit where id_produit = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
