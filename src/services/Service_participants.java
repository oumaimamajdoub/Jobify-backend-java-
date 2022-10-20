/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Participant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Myconnection;

/**
 *
 * @author LENOVO
 */
public class Service_participants {
    private final Connection conn;
    private Statement ste;
    private PreparedStatement pste;
    
     public Service_participants () {
     conn = Myconnection.getInstance().getCnx();   
    }
     

    public void ajouter(Participant p) {
String req = "INSERT INTO `participant`(`id_ev`,`id_user`) VALUES (?,?)";
        try {
               
            pste = conn.prepareStatement(req);
            pste.setInt(1,p.getId_ev());
            pste.setInt(2,p.getId_user());
           
            pste.execute();
            System.out.println("participants ajouter");
        } catch (SQLException ex) {
         Logger.getLogger(Service_participants.class.getName()).log(Level.SEVERE, null, ex);        }   
    }
   
    public void modifier(Participant p) {
       String req = "UPDATE participant SET id_ev=?,id_user=? WHERE id_participant=?";
    try {
            //pste = conn.prepareStatement(req);
            pste = conn.prepareStatement(req);
           pste.setInt(1,p.getId_ev());
            pste.setInt(2,p.getId_user());
             pste.setInt(3,p.getId_pr());
          
           pste.executeUpdate();
         /**  int rowsUpdated = pste.executeUpdate();
             if (rowsUpdated > 0) {**/
            System.out.println("La modification de participant a été éffectuée avec succès ");
           // }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());   
        }
    }
    
 public void Supprimer(Participant p) {
    try {
            String req = "DELETE FROM `participant` WHERE `id_participant` =?";
            PreparedStatement pste = conn.prepareStatement(req);
            pste.setInt(1,p.getId_pr());
            pste.executeUpdate();
            System.out.println("participants supprimé");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           // Logger.getLogger(Service_evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public List<Participant> afficher() {
    List<Participant> Participant = new ArrayList<>();
        String req = "SELECT * FROM `Participant`";
        
        try {
            
            ste = conn.createStatement();
            ResultSet resultSet = ste.executeQuery(req);
            
            while(resultSet.next()){
               Participant p = new Participant();
                p.setId_pr(resultSet.getInt(1));
                p.setId_ev(resultSet.getInt(2));
                 p.setId_user(resultSet.getInt(3));
                Participant.add(p);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(Service_evenement.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return Participant;
    }
}
  


   
 
