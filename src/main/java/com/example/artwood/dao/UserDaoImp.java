package com.example.artwood.dao;

import com.example.artwood.entities.User;
import com.example.artwood.outils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImp implements IUserDao{

    private Connection connection;


    public UserDaoImp() {
        connection = ConnectionDB.getConnectionDB();
    }
    @Override

    public User authenticateUser(String email, String password) {
        try {
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM users WHERE email_user=? AND password=?");
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet resultSet = pst.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getNString("nom_user"),
                        resultSet.getNString("prenom_user"),
                        resultSet.getNString("email_user"),
                        resultSet.getNString("password"));
            }
            resultSet.close();
            pst.close();
            return user;
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
    }


}
