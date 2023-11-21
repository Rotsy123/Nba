package com.example.GestionVehicule.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rebond {
    int idRebond;
    int idTir;
    int idJoueur;
    int idMatch;
    int valeur;
    Date daterebond;

    public double GetStatisticRebond(int joueur) throws SQLException {
        int all = this.GetAllRebond(joueur);
        int nbmatch = Joueur.NbMatchJoueur(joueur);
        if(all!=0 && nbmatch!=0){
            return all/nbmatch;
        }
        return 0;
    }
    public int GetAllRebond(int joueur) throws SQLException {
        Connexion c = new Connexion();
        String requete = "select count(id_rebond) from rebond where id_joueur = "+ joueur;
        PreparedStatement preparedStatement = c.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        int nbpoint = 0;
        if (resultSet.next()) {
            nbpoint = resultSet.getInt(1);
        }
        c.GetConnection().close();
        return nbpoint;
    }
    public int GetRebondParValeur( int valeur, int joueur) throws SQLException {
        Connexion c = new Connexion();
        String requete = "select count(id_rebond) from rebond where valeur = "+valeur +" and id_joueur = "+ joueur;
        PreparedStatement preparedStatement = c.GetConnection().prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        int nbpoint = 0;
        if (resultSet.next()) {
            nbpoint = resultSet.getInt(1);
        }
        c.GetConnection().close();
        return nbpoint;
    }
    public  Rebond(){}
    public Rebond(int idRebond, int idTir, int idJoueur, int idMatch, int valeur, Date daterebond) {
        this.idRebond = idRebond;
        this.idTir = idTir;
        this.idJoueur = idJoueur;
        this.idMatch = idMatch;
        this.valeur = valeur;
        this.daterebond = daterebond;
    }

    public int getIdRebond() {
        return idRebond;
    }

    public void setIdRebond(int idRebond) {
        this.idRebond = idRebond;
    }

    public int getIdTir() {
        return idTir;
    }

    public void setIdTir(int idTir) {
        this.idTir = idTir;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Date getDaterebond() {
        return daterebond;
    }

    public void setDaterebond(Date daterebond) {
        this.daterebond = daterebond;
    }
}
