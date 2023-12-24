package com.example.artwood.dao;



import com.example.artwood.entities.Client;
import com.example.artwood.outils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp implements IClientDao {
    Connection connection = ConnectionDB.getConnectionDB();

    @Override
    public Client ajouterClient(Client c) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into client (nom_user,prenom_user,adresse) Values(?,?,?)");
            preparedStatement.setString(1, c.getNom_client());
            preparedStatement.setString(2, c.getPrenom_client());
            preparedStatement.setString(3, c.getAdresse());
            preparedStatement.executeUpdate();
            PreparedStatement ps = connection.prepareStatement("select max(user_id) as maxid from client");
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                c.setId_client(resultSet.getInt("MAX_id"));
                // logger.info("le client est bien ajouté");

            }
            preparedStatement.close();
        } catch (SQLException e) {
            //logger.error("Erreur lors de l'ajout de ce client", e);
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Client> listeClients() {
        ArrayList<Client> listeClients = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from client");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId_client(rs.getInt("id_client"));
                client.setNom_client(rs.getString("nom_client"));
                client.setPrenom_client(rs.getString("prenom_client"));
                client.setAdresse(rs.getString("adresse"));
                listeClients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeClients;
    }

    @Override
    public Client rechercherClient(int id) {
        Client client = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM client where client_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client.setId_client(rs.getInt("user_id"));
                client.setNom_client(rs.getString("nom_user"));
                client.setPrenom_client(rs.getString("prenom_user"));
                client.setAdresse(rs.getString("adresse"));

            }
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        if (client == null) throw new RuntimeException("Client " + id + " est introuvable");
        return client;
    }

    @Override
    public void modifierClient(Client c) {
        try {
            PreparedStatement ps = connection.prepareStatement("update client set nom_client = ?, prenom_client = ?, adresse = ? where client_id = ?");
            ps.setString(1, c.getNom_client());
            ps.setString(2, c.getPrenom_client());
            ps.setString(3, c.getAdresse());
            ps.setInt(4, c.getId_client());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void supprimerClient(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete FROM client where client_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
