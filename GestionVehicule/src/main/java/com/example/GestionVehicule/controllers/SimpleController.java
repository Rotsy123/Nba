package com.example.GestionVehicule.controllers;

import com.example.GestionVehicule.model.Connexion;
import com.example.GestionVehicule.model.Equipe;
import com.example.GestionVehicule.model.Joueur;
import com.example.GestionVehicule.model.Tir;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SimpleController {
    @GetMapping("/listeEquipe")
    public List<Equipe> ListeJoueur() throws SQLException {
        Connexion c = new Connexion();
        List<Equipe> lj = new Equipe().GetAll(c);

        return lj;
    }
    @GetMapping("/listejoueur")
    public List<Joueur> Joueur() throws SQLException {
        Connexion c = new Connexion();
        List<Joueur> lj = new Joueur().GetAll(c);
        for(int i=0; i<lj.size(); i++){
            System.out.println(lj.get(i).GetEquipe().getNomEquipe());
        }
        return lj;
    }
    @GetMapping("/stat")
    public double StatTir(int valeur, int joueur, int reussi)throws  SQLException{
        return new Tir().StatistiqueTir(valeur, joueur, reussi);
    }
}
//    @Value("${spring.application.name}")
//    String appName;
//    @Autowired UsersRepository users;
//    @Autowired VoitureBaseRepository voiture;
//
//    @GetMapping("/")
//    public String homePage() {
//        return "home";
//    }
//    @GetMapping("/homie")
//    public String homePages(String donne) {
//        Home home = new Home();
//        String hello = home.hello();
//        return  donne;
//    }
//    @GetMapping("/login")
//    public Users login(String mail,String mdp) {
//        System.out.println(mail+" dm:"+mdp);
//        Users user = users.findByMailAndMdp(mail,mdp);
//        return  user;
//    }
//
//    @GetMapping("/json")
//    public Voiture responseJson(){
//        List<VoitureBase> voit = voiture.findAll();
//        VoitureBase[] voitures = voit.toArray(new VoitureBase[voit.size()]) ;
//        Voiture tomobil = new Voiture();
//        try {
//            tomobil.setData(voitures);
//        } catch (Exception e) {
//            tomobil.setErreur(e.getMessage());
//            e.printStackTrace();
//        }
//        return  tomobil;
//    }
