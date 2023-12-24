package com.example.artwood.outils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {

    private static final String username ="root";
    private static final  String password = "";
    private static final  String url ="jdbc:mysql://localhost:3306/craft";
    private static Connection connection = null;
    private static final Logger logger = LogManager.getLogger(ConnectionDB.class);
    public static Connection getConnectionDB() {
        if(connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException e) {
                logger.error("Erreur dans la base de données", e);
                throw new RuntimeException(e);

            }

        }
        return  connection;
    }
}
