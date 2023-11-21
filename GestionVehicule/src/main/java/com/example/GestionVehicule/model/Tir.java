package com.example.GestionVehicule.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tir {
    int idTir;
    int id_Joueur;
    int id_Match;
    Date dateTir;
    int valeur;
    int reussite;

    public double StatistiqueTir(int valeur, int joueur, int reussi) throws SQLException {
        int point = this.GetPoint(valeur, joueur, reussi);
        int tir = this.GetTir(valeur, joueur);
        if(point!=0 && tir!=0 ){
            double statistique = point * 100 /tir;
            return statistique;
        }
        double retour = 0;
        return retour;
    }
    //ATO NY ISANA POINTS MATY (VALEUR)
    public int GetPoint(int valeur, int id_Joueur, int reussi) throws SQLException {
        Connexion connexion = new Connexion();
        String requete = "SELECT count(id_tir) FROM tir where valeur = "+valeur+" and id_Joueur ="+id_Joueur+" and reussite ="+reussi;
        PreparedStatement preparedStatement = connexion.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        int nbpoint = 0;
        if (resultSet.next()) {
            nbpoint = resultSet.getInt(1);
        }
        connexion.GetConnection().close();
        return nbpoint;
    }
    //AZO AMTY OE LANCER FIRY, 3PTS FIRY , LANCER FRONT FIRY /joueur
    public int GetTir(int valeur, int id_Joueur) throws SQLException {
        Connexion connexion = new Connexion();
        String requete = "SELECT count(id_Tir) FROM tir where valeur = "+valeur+" and id_Joueur ="+id_Joueur;
        PreparedStatement preparedStatement = connexion.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        int nbpoint = 0;
        if (resultSet.next()) {
            nbpoint = resultSet.getInt(1);
        }
        connexion.GetConnection().close();
        return nbpoint;
    }
    public Tir() {
    }

    public Tir(int idTir, int id_Joueur, int id_Match, Date dateTir, int valeur, int reussite) {
        this.idTir = idTir;
        this.id_Joueur = id_Joueur;
        this.id_Match = id_Match;
        this.dateTir = dateTir;
        this.valeur = valeur;
        this.reussite = reussite;
    }

    public int getIdTir() {
        return idTir;
    }

    public void setIdTir(int idTir) {
        this.idTir = idTir;
    }

    public int getId_Joueur() {
        return id_Joueur;
    }

    public void setId_Joueur(int id_Joueur) {
        this.id_Joueur = id_Joueur;
    }

    public int getId_Match() {
        return id_Match;
    }

    public void setId_Match(int id_Match) {
        this.id_Match = id_Match;
    }

    public Date getDateTir() {
        return dateTir;
    }

    public void setDateTir(Date dateTir) {
        this.dateTir = dateTir;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getReussite() {
        return reussite;
    }

    public void setReussite(int reussite) {
        this.reussite = reussite;
    }
}
