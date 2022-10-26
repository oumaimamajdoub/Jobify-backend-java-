/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import edu.esprit.entities.User;
import edu.esprit.entities.admin;
import edu.esprit.entities.candidate;
import edu.esprit.utils.MyConnection;
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
     public void ajouteradmin(admin fp){
        try {
            String requete1 = "INSERT INTO user (email,mdp,Role)"
                    + "VALUES (?,?,'admin')";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete1);
            
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
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
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
    public void modifieradmin(String a, admin fp){
        
        try {
            String requete3 = " UPDATE `user` SET `email`=?,`mdp`=? WHERE email=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete3);
            
            pst.setString(1, fp.getEmail());
            pst.setString(2, fp.getMdp());
            pst.setString(3, a);
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
            Statement st = new MyConnection().getCnx().createStatement();
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

    public List<admin> afficheradminbyId(int id) {
        List<admin> myList = new ArrayList<admin>();
        try {
            String requete4 = "SELECT * FROM user where id=" + id + " AND Role='admin'";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while (rs.next()) {
                admin fp = new admin();
                fp.setId(rs.getInt(1));
                fp.setEmail(rs.getString("email"));
                fp.setMdp(rs.getString("mdp"));
                myList.add(fp);

            }
            return myList;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    
}
