package com.example.GestionVehicule.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
public class Connexion {

    String url = "jdbc:mysql://localhost:3306/banque";
    String utilisateur = "archlog";
    String motDePasse = "root";


    public Connection GetConnection() {
        Connection connexion = null;

        try {
            if(connexion == null){
                connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobilenba", "root", "root");
                System.out.println("Connexion à la base de données MySQL réussie !");
            }else{
                System.out.println("Conn existant");
            }

        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
        return connexion;
    }
}


