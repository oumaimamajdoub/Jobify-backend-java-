/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;



import edu.esprit.entities.candidate;
import edu.esprit.entities.entrepreneur;
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
public class candidateCRUD {
     public void ajoutercandidate(candidate fp){
        try {
            String requete1 = "INSERT INTO user (age,nom,prenom,email,mdp,numTel,Adresse,Role)"
                    + "VALUES (?,?,?,?,?,?,?,'candidate')";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete1);
            pst.setInt(1, fp.getAge());
            pst.setString(2, fp.getNom());
            pst.setString(3, fp.getPrenom());
            pst.setString(4, fp.getEmail());
            pst.setString(5, fp.getMdp());
            pst.setString(6, fp.getNumTel());
            pst.setString(7, fp.getAdresse());
            pst.executeUpdate();
            System.out.println("candidate ajouté avec succés! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
    }
    public void supprimercandidate(int id){
        
        try {
            String requete2 = "DELETE FROM user WHERE id =?";
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("candidate supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimercandidateByEmail(String email){
        
        try {
            String requete2 = "DELETE FROM user WHERE email =?";
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
            st.setString(1, email);
            st.executeUpdate();
            System.out.println("candidate supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param fp
     * @param fp1
     */
    public void modifiercandidate(String a, candidate fp){
        
        try {
            String requete3 = " UPDATE `user` SET `age`=?,`nom`=?,`prenom`=?,`email`=?,`mdp`=?,`numTel`=?,`Adresse`=? WHERE email=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete3);
            pst.setInt(1, fp.getAge());
            pst.setString(2, fp.getNom());
            pst.setString(3, fp.getPrenom());
            pst.setString(4, fp.getEmail());
            pst.setString(5, fp.getMdp());
            pst.setString(6, fp.getNumTel());
            pst.setString(7, fp.getAdresse());
            pst.setString(8, a);
            pst.executeUpdate();
            System.out.println("candidate modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<candidate> affichercandidate(){
        List<candidate> myList = new ArrayList<candidate>();
        try {  
            String requete4 = "SELECT * FROM user";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                candidate fp = new candidate();
                fp.setId(rs.getInt(1));
                fp.setAge(rs.getInt(2));
                fp.setNom(rs.getString("nom"));
                fp.setPrenom(rs.getString("prenom"));
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
    
    public List<candidate> affichercandidatebyId(int id) {
        List<candidate> myList = new ArrayList<candidate>();
        try {
            String requete4 = "SELECT * FROM user where id=" + id + " AND Role='candidate'";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while (rs.next()) {
                candidate fp = new candidate();
                fp.setId(rs.getInt(1));
                fp.setAge(rs.getInt(2));
                fp.setNom(rs.getString("nom"));
                fp.setPrenom(rs.getString("prenom"));
                fp.setEmail(rs.getString("email"));
                fp.setMdp(rs.getString("mdp"));
                fp.setNumTel(rs.getString("numTel"));
                fp.setAdresse(rs.getString("Adresse"));
                myList.add(fp);

            }
            return myList;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
}
