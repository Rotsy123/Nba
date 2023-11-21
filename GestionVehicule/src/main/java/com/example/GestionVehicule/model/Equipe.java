package com.example.GestionVehicule.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    int idEquipe;
    String nomEquipe;
    Date DateCreation;

    public List<Equipe> GetAll(Connexion c) throws SQLException {
        List<Equipe> allequipe = new ArrayList<>();
        Connexion connexion = new Connexion();
        String requete = "SELECT*from equipe";
        PreparedStatement preparedStatement = connexion.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String nom = resultSet.getString(2);
            Date creation = resultSet.getDate(3);

            Equipe temp = new Equipe(id, nom, creation);
            allequipe.add(temp);
        }
        connexion.GetConnection().close();
        return allequipe;
    }
    public Equipe(){}
    public Equipe(int idEquipe, String nomEquipe, Date dateCreation) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        DateCreation = dateCreation;
    }
    public int getIdEquipe() {
        return idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public Date getDateCreation() {
        return DateCreation;
    }
}


