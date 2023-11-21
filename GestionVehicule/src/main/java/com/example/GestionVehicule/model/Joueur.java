package com.example.GestionVehicule.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Joueur {
    int idJoueur;
    String Nom;
    String Prenom;
    Date Datedenaissance;
    Equipe Equipe;

    public static int NbMatchJoueur(int idJoueur)throws SQLException{
        Connexion c = new Connexion();
        String requete = " SELECT NombreMatchsJouesParJoueur("+idJoueur+") AS MatchsJouesPourJoueur1";
        PreparedStatement preparedStatement = c.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        int nbpoint = 0;
        if (resultSet.next()) {
            nbpoint = resultSet.getInt(1);
        }
        c.GetConnection().close();
        return nbpoint;
    }
    public List<Joueur> GetAll(Connexion c, int idequipe) throws SQLException {
        List<Joueur> alljoueur = new ArrayList<>();
        Connexion connexion = new Connexion();
        String requete = "SELECT * FROM Joueur LEFT JOIN EquipeJoueur ON joueur.id_Joueur = equipejoueur.id_Joueur LEFT JOIN Equipe  ON equipejoueur.id_Equipe = equipe.id_Equipe WHERE equipejoueur.DateSortie is NULL and equipe.id_Equipe= "+idequipe;
        PreparedStatement preparedStatement = connexion.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(9);
            String nom = resultSet.getString(10);
            Date creation = resultSet.getDate(11);
            Equipe temp = new Equipe(id, nom, creation);
            Joueur j = new Joueur(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getDate(4), temp);
            alljoueur.add(j);
        }
        connexion.GetConnection().close();
        return alljoueur;
    }
    public int getIdJoueur() {
        return idJoueur;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }
    public Equipe GetEquipe(){
        return  this.Equipe;
    }
    public Date getDatedenaissance() {
        return Datedenaissance;
    }

    public Joueur(int idJoueur, String nom, String prenom, Date datedenaissance, Equipe equipe) {
        this.idJoueur = idJoueur;
        Nom = nom;
        Prenom = prenom;
        Datedenaissance = datedenaissance;
        Equipe = equipe;
    }
    public Joueur(){}
}
