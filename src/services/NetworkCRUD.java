/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Network;
import entities.Profil;
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
public class NetworkCRUD {
    Connection cn ;
    public NetworkCRUD(){
        
        cn = MyDB.getInstance().getCnx();
    }
    public void ajouterNetwork(Network p){
       try {
           String req = "INSERT INTO network(discussion,groupe,notification) VALUES(?,?,?)";
           PreparedStatement pst =  cn.prepareStatement(req);
           pst.setString(1, p.getDiscussion());
           pst.setString(2, p.getGroupe());
           pst.setString(3, p.getNotification());
           
           pst.executeUpdate();
           System.out.println("le Network  est ajouter");
           
       } catch (SQLException ex) {
           System.err.println(ex);
       }

        
    }
    //VALUES('"+u.getNom()+"','"+u.gePrenom()+"','"+u.getAge()+"')'";
    public void supprimerNetwork(Network p){
        try {
            String requete = "DELETE FROM network WHERE iddus=?";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, p.getIddus());
            pst.executeUpdate();
            System.out.println("network supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void modifierNetwork(Network p){
        try {
            String requete = "UPDATE network SET discussion=?,groupe=?,notification=? WHERE iddus=?";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, p.getDiscussion());
            pst.setString(2, p.getGroupe());
            pst.setString(3, p.getNotification());
           pst.setInt(4, p.getIddus());
           
            pst.executeUpdate();
            System.out.println("Network modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    
    public List<Network> afficherNetwork(){
        List<Network> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM network";
            PreparedStatement pst = cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Network(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
