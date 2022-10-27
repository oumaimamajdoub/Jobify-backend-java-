/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.ProfilUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import outils.MyDB;

/**
 *
 * @author Ismail
 */
public class ProfiluserCRUD {
     Connection cn ;
    public ProfiluserCRUD(){
        
        cn = MyDB.getInstance().getCnx();
    }
    public void ajouterProfiluser(ProfilUser p){
       try {
           String req = "INSERT INTO profiluser(nom,prenom,addresse,code_postal,nationalite,phone,sexe,competences,language,entreprise,ecole,linkdin,github) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement pst =  cn.prepareStatement(req);
           pst.setString(1, p.getNom());
           pst.setString(2, p.getPrenom());
           pst.setString(3, p.getAddresse());
           pst.setInt(4, p.getCode_postal());
           pst.setString(5, p.getNationalite());
           pst.setInt(6, p.getPhone());
           pst.setString(7, p.getSexe());
           pst.setString(8, p.getCompetences());
           pst.setString(9, p.getLanguage());
           pst.setString(10, p.getEntreprise());
           pst.setString(11, p.getEcole());
           pst.setString(12, p.getLinkdin());
           pst.setString(13, p.getGithub());
           pst.executeUpdate();
           System.out.println("le profil user est ajouter");
           
       } catch (SQLException ex) {
           System.err.println(ex);
       }

        
    }
    //VALUES('"+u.getNom()+"','"+u.gePrenom()+"','"+u.getAge()+"')'";
    public void supprimerProfiluser(ProfilUser p){
        try {
            String requete = "DELETE FROM profiluser WHERE id=?";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Profil user supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void modifierProfiluser(ProfilUser p){
        try {
            String requete = "UPDATE profiluser SET nom=?,prenom=?,addresse=?,code_postal=?,nationalite=?,phone=?,sexe=?,competences=?,language=?,entreprise=?,ecole=?,linkdin=?,github=? WHERE id=?";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(14, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAddresse());
           pst.setInt(4, p.getCode_postal());
           pst.setString(5, p.getNationalite());
           pst.setInt(6, p.getPhone());
           pst.setString(7, p.getSexe());
           pst.setString(8, p.getCompetences());
           pst.setString(9, p.getLanguage());
           pst.setString(10, p.getEntreprise());
           pst.setString(11, p.getEcole());
           pst.setString(12, p.getLinkdin());
           pst.setString(13, p.getGithub());
            pst.executeUpdate();
            System.out.println("Profil user modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    
    public List<ProfilUser> afficherProfiluser(){
        List<ProfilUser> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM profiluser";
            PreparedStatement pst = cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ProfilUser(rs.getInt("id"), rs.getString(2), rs.getString("prenom"), rs.getString("addresse"), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
            }

        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
        }

        return list;
    }
   
    
}
