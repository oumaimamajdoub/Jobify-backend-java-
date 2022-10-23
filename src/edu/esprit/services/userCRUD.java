/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.User;
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
public class userCRUD {
    Connection Cnx;
    public userCRUD(){
        Cnx=MyConnection.getInstance().getCnx();
    }
    public void ajouteruser(User fp){
        try {
            String requete1 = "INSERT INTO user (age,nom,prenom,email,mdp,numTel,Adresse,Role)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = Cnx.prepareStatement(requete1);
            pst.setInt(1, fp.getAge());
            pst.setString(2, fp.getNom());
            pst.setString(3, fp.getPrenom());
            pst.setString(4, fp.getEmail());
            pst.setString(5, fp.getMdp());
            pst.setString(6, fp.getNumTel());
            pst.setString(7, fp.getAdresse());
            pst.setString(8, fp.getRole());
            pst.executeUpdate();
            System.out.println("user ajouté avec succés! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
    }
    public void supprimeruser(int id){
        
        try {
            String requete2 = "DELETE FROM user WHERE id =?";
            PreparedStatement st = Cnx.prepareStatement(requete2);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("user supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param fp
     * @param fp1
     */
    public void modifierUser(int a, User fp){
        
        try {
            String requete3 = " UPDATE `user` SET `age`=?,`nom`=?,`prenom`=?,`email`=?,`mdp`=?,`numTel`=?,`Adresse`=?,`Role`=? WHERE id=?";
            PreparedStatement pst = Cnx.prepareStatement(requete3);
            pst.setInt(1, fp.getAge());
            pst.setString(2, fp.getNom());
            pst.setString(3, fp.getPrenom());
            pst.setString(4, fp.getEmail());
            pst.setString(5, fp.getMdp());
            pst.setString(6, fp.getNumTel());
            pst.setString(7, fp.getAdresse());
            pst.setString(8, fp.getRole());
            pst.setInt(9, a);
            pst.executeUpdate();
            System.out.println("user modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<User> afficherUser(){
        List<User> myList = new ArrayList<User>();
        try {  
            String requete4 = "SELECT * FROM user";
            Statement st = Cnx.createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                User fp = new User();
                fp.setId(rs.getInt(1));
                fp.setAge(rs.getInt(2));
                fp.setNom(rs.getString("nom"));
                fp.setPrenom(rs.getString("prenom"));
                fp.setEmail(rs.getString("email"));
                fp.setMdp(rs.getString("mdp"));
                fp.setNumTel(rs.getString("numTel"));
                fp.setAdresse(rs.getString("Adresse"));
                fp.setEtat(rs.getString("Role"));
                myList.add(fp);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    /*
    public void calculer_Salaire( fiche_de_paie fp1,int nbr){
        try {
            System.out.println("calculer la salaire ");
            int salaire_Sans_Prime;
            if (nbr<50){salaire_Sans_Prime=nbr*12;}
            else{salaire_Sans_Prime=50*12+(nbr-50)*15;}
            String rqt = " UPDATE fiche_de_paie SET `Salaire_init`=? WHERE ID_FP=?";
            PreparedStatement pst = Cnx.prepareStatement(rqt);
            pst.setInt(1,salaire_Sans_Prime);
            pst.setInt(2, fp1.getID_FP());
            }
         catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
*/
}
     