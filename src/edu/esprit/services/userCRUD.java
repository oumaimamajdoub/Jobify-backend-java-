/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.User;
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
public class userCRUD {
    public void ajouteruser(User fp){
        try {
            String requete1 = "INSERT INTO user (age,nom,prenom,email,mdp,numTel,Adresse,Role)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete1);
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
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("user supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimeruserByEmail(String email){
        
        try {
            String requete2 = "DELETE FROM user WHERE email =?";
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
            st.setString(1, email);
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
    public void modifierUser(String a, User fp){
        
        try {
            String requete3 = " UPDATE `user` SET `age`=?,`nom`=?,`prenom`=?,`email`=?,`mdp`=?,`numTel`=?,`Adresse`=?,`Role`=? WHERE email=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete3);
            pst.setInt(1, fp.getAge());
            pst.setString(2, fp.getNom());
            pst.setString(3, fp.getPrenom());
            pst.setString(4, fp.getEmail());
            pst.setString(5, fp.getMdp());
            pst.setString(6, fp.getNumTel());
            pst.setString(7, fp.getAdresse());
            pst.setString(8, fp.getRole());
            pst.setString(9, a);
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
            Statement st = new MyConnection().getCnx().createStatement();
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
    
    
    public User afficherUserbyId(int id){
        List<User> myList = new ArrayList<User>();
        try {  
            String requete4 = "SELECT * FROM user where id="+id;
            Statement st = new MyConnection().getCnx().createStatement();
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
                return fp;
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    /**
     *
     * @param id
     */
    public void supprimerUser(int id){
        
        try {
            String requete2 = "DELETE FROM user WHERE id =?";
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete2);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("user supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public User login(User u){
    try {
            String req4="SELECT * FROM `user` WHERE email='"+u.getEmail()+"' AND `mdp`='"+u.getMdp()+"'";
            
            PreparedStatement st = new MyConnection().getCnx().prepareStatement(req4);
            
            
            ResultSet rs = st.executeQuery(req4);
            
                User ps=new User();
                ps.setId(-1);
                while(rs.next()){
                ps.setId(rs.getInt("id"));
                ps.setAge(rs.getInt("age"));
                ps.setNom(rs.getString("nom"));
                ps.setPrenom(rs.getString("prenom"));
                ps.setEmail(rs.getString("email"));
                ps.setMdp(rs.getString("mdp"));
                ps.setNumTel(rs.getString("numTel"));
                ps.setAdresse(rs.getString("adresse"));
                ps.setRole(rs.getString("role"));
                System.err.println("t3adet \n");
                }

                
            
                return ps;
            
        } catch (SQLException ex) {
            System.err.println("mat3adetch \n"+ex.getMessage());
            return null;
        }
    }
    public void updateUserMdp(String mail, String mdp) {
        
        try {
            String requete3 = " UPDATE `user` SET `mdp`=? WHERE email=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete3);
            
            pst.setString(1, mdp);
            pst.setString(2, mail);
            pst.executeUpdate();
            System.out.println("user modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
     
            
                
           