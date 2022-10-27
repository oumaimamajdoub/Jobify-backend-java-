/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ProfilCompany;
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
public class ProfilcompanyCRUD {
     Connection cn ;
    public ProfilcompanyCRUD(){
        
        cn = MyDB.getInstance().getCnx();
    }
    public void ajouterProfilcr(ProfilCompany p){
       try {
           String req = "INSERT INTO profilcompany(nom,addresse,code_postal,phone,maplong,maplarg,linkdin,image) VALUES(?,?,?,?,?,?,?,?)";
           PreparedStatement pst =  cn.prepareStatement(req);
           pst.setString(1, p.getNom());
          // pst.setString(2, p.getPrenom());
           pst.setString(2, p.getAddresse());
           pst.setInt(3, p.getCode_postal());
          //pst.setString(5, p.getNationalite());
           pst.setInt(4, p.getPhone());
           /*pst.setString(7, p.getSexe());
           pst.setString(8, p.getCompetences());
           pst.setString(9, p.getLanguage());
           pst.setString(10, p.getEntreprise());*/
           pst.setFloat(5, p.getMaplong());
           pst.setString(7, p.getLinkdin());
           pst.setString(8, p.getImage());
           pst.setFloat(6, p.getMaplarg());
           pst.executeUpdate();
           System.out.println("le profil company est ajouter");
           
       } catch (SQLException ex) {
           System.err.println(ex);
       }

        
    }
    //VALUES('"+u.getNom()+"','"+u.gePrenom()+"','"+u.getAge()+"')'";
    public void supprimerProfilcr(ProfilCompany p){
        try {
            String requete = "DELETE FROM profilcompany WHERE id=?";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Profil company supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void modifierProfilcr(ProfilCompany p){
        try {
            String requete = "UPDATE profilcompany SET nom=?,addresse=?,code_postal=?,phone=?,maplong=?,maplarg=?,linkdin=? WHERE id=?";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(8, p.getId());
            pst.setString(1, p.getNom());
            //pst.setString(2, p.getPrenom());
            pst.setString(2, p.getAddresse());
           pst.setInt(3, p.getCode_postal());
          // pst.setString(5, p.getNationalite());
           pst.setInt(4, p.getPhone());
          /* pst.setString(7, p.getSexe());
           pst.setString(8, p.getCompetences());
           pst.setString(9, p.getLanguage());
           pst.setString(10, p.getEntreprise());
           pst.setString(11, p.getEcole());*/
           pst.setFloat(5, p.getMaplong());
           pst.setFloat(6, p.getMaplarg());
           pst.setString(7, p.getLinkdin());
           //pst.setString(13, p.getGithub());
            pst.executeUpdate();
            System.out.println("Profil company modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    
    public List<ProfilCompany> afficherProfilcr(){
        List<ProfilCompany> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM profilcompany";
            PreparedStatement pst = cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ProfilCompany(rs.getInt("id"), rs.getString(2),  rs.getString("addresse"), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getFloat(7),rs.getString(8) ));
            }

        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
        }

        return list;
    }

}
