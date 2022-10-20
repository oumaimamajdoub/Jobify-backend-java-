/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.User;
import edu.esprit.entities.entrepreneur;
import edu.esprit.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class entrepreneurCRUD {
     public void ajouterentrepreneur(entrepreneur fp){
        try {
            String requete1 = "INSERT INTO user (nom,email,mdp,numTel,Adresse,Role)"
                    + "VALUES (?,?,?,?,?,'entrepreneur')";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete1);
            
            pst.setString(1, fp.getNom());
            pst.setString(2, fp.getEmail());
            pst.setString(3, fp.getMdp());
            pst.setString(4, fp.getNumTel());
            pst.setString(5, fp.getAdresse());
            pst.executeUpdate();
            System.out.println("entrepreneur ajouté avec succés! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
    }
    public void supprimerentrepreneur(int id){
        
        try {
            String requete2 = "DELETE FROM user WHERE id =?";
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("entrepreneur supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param fp
     * @param fp1
     */
    public void modifierentrepreneur(int a, entrepreneur fp){
        
        try {
            String requete3 = " UPDATE `user` SET ``nom`=?,`email`=?,`mdp`=?,`numTel`=?,`Adresse`=? WHERE id=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete3);
            pst.setString(1, fp.getNom());
            pst.setString(2, fp.getEmail());
            pst.setString(3, fp.getMdp());
            pst.setString(4, fp.getNumTel());
            pst.setString(5, fp.getAdresse());
            pst.setInt(6, a);
            pst.executeUpdate();
            System.out.println("entrepreneur modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<entrepreneur> afficherentrepreneur(){
        List<entrepreneur> myList = new ArrayList<entrepreneur>();
        try {  
            String requete4 = "SELECT * FROM user";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                entrepreneur fp = new entrepreneur();
                fp.setId(rs.getInt(1));
                fp.setNom(rs.getString("nom"));
                fp.setEmail(rs.getString("email"));
                fp.setMdp(rs.getString("mdp"));
                fp.setNumTel(rs.getString("numTel"));
                fp.setAdresse(rs.getString("Adresse"));
                fp.setRole(rs.getString("Role"));
                myList.add(fp);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    public void ajouteruser(entrepreneur e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ajouterentrep(entrepreneur e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
