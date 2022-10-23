/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import edu.esprit.entities.User;
import edu.esprit.entities.admin;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class adminCRUD {
    Connection Cnx;
    public adminCRUD(){
        Cnx=MyConnection.getInstance().getCnx();
    }
    
     public void ajouteradmin(admin fp){
        try {
            String requete1 = "INSERT INTO user (email,mdp,Role)"
                    + "VALUES (?,?,'admin')";
            PreparedStatement pst = Cnx.prepareStatement(requete1);
            
            pst.setString(1, fp.getEmail());
            pst.setString(2, fp.getMdp());
            pst.executeUpdate();
            System.out.println("Admin ajouté avec succés! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
    }
    public void supprimeradmin(int id){
        
        try {
            String requete2 = "DELETE FROM user WHERE id =?";
            PreparedStatement st = Cnx.prepareStatement(requete2);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Admin supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param fp
     * @param fp1
     */
    public void modifieradmin(int a, admin fp){
        
        try {
            String requete3 = " UPDATE `user` SET `age`=?,`nom`=?,`prenom`=?,`email`=?,`mdp`=?,`numTel`=?,`Adresse`=? WHERE id=?";
            PreparedStatement pst = Cnx.prepareStatement(requete3);
            
            pst.setString(1, fp.getEmail());
            pst.setString(2, fp.getMdp());
            pst.setInt(8, a);
            pst.executeUpdate();
            System.out.println("Admin modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<admin> afficheradmin(){
        List<admin> myList = new ArrayList<admin>();
        try {  
            String requete4 = "SELECT * FROM user";
            Statement st = Cnx.createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                admin fp = new admin();
                fp.setId(rs.getInt(1));
                fp.setEmail(rs.getString("email"));
                fp.setMdp(rs.getString("mdp"));
                fp.setRole(rs.getString("Role"));
                myList.add(fp);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
