/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Evenement;
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
public class Service_evenement {
    private final Connection conn;
    private Statement ste;
    private PreparedStatement pste;
    
     public Service_evenement () {
     conn = Myconnection.getInstance().getCnx();   
    }
     

    public void ajouter(Evenement ev) {
String req = "INSERT INTO `evenement`(`id_ev`,`nom_ev`,`date_debut_ev`,`date_fin_ev`,`organisateur_ev`,`lieu_ev`,`disponibilite_ev`,`programme_ev`,`num_contact`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
               
            pste = conn.prepareStatement(req);
            pste.setInt(1,ev.getId_ev());
            pste.setString(2, ev.getNom_ev());
            pste.setString(3, ev.getDate_debut_ev());
            pste.setString(4, ev.getDate_fin_ev());
            pste.setInt(5, ev.getOrganisateur_ev());
            pste.setString(6, ev.getLieu_ev());
            pste.setString(7, ev.getDisponibilite_ev());
            pste.setString(8, ev.getProgramme_ev());
            pste.setInt(9, ev.getNum_contact());
        
           
            pste.execute();
            System.out.println("Evenement créée");
        } catch (SQLException ex) {
            Logger.getLogger(Service_evenement.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    public void modifierev(Evenement ev) {
        String req = "UPDATE evenement SET  nom_ev=? ,date_debut_ev=?,date_fin_ev=?,organisateur_ev=?,lieu_ev=?,disponibilite_ev=?,programme_ev=?,num_contact=? WHERE id_ev=?";
    try {
            //pste = conn.prepareStatement(req);
            pste = conn.prepareStatement(req);
            pste.setInt(9,ev.getId_ev());
            pste.setString(1, ev.getNom_ev());
            pste.setString(2, ev.getDate_debut_ev());
            pste.setString(3, ev.getDate_fin_ev());
            pste.setInt(4, ev.getOrganisateur_ev());
            pste.setString(5, ev.getLieu_ev());
            pste.setString(6, ev.getDisponibilite_ev());
            pste.setString(7, ev.getProgramme_ev());
            pste.setInt(8, ev.getNum_contact()); 
            
           pste.executeUpdate();
         /**  int rowsUpdated = pste.executeUpdate();
             if (rowsUpdated > 0) {**/
            System.out.println("La modification de evenement a été éffectuée avec succès ");
           // }
        } catch (SQLException ex) {
            System.out.println(ex);   
        }
    }
    
 public void Supprimer(Evenement ev) {
    try {
            String req = "DELETE FROM `evenement` WHERE `id_ev` = "+ ev.getId_ev()+ "";
            pste = conn.prepareStatement(req);
            pste.executeUpdate();
            System.out.println("evenement supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(Service_evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

  

    public List<Evenement> afficher() {
    List<Evenement> Evenement = new ArrayList<>();
        String req = "SELECT * FROM `Evenement`";
        
        try {
            
            ste = conn.createStatement();
            ResultSet resultSet = ste.executeQuery(req);
            
            while(resultSet.next()){
                Evenement ev = new Evenement();
                ev.setId_ev(resultSet.getInt(1));
                ev.setNom_ev(resultSet.getString(2));
                ev.setDate_debut_ev(resultSet.getString(3));
                ev.setDate_fin_ev(resultSet.getString(4));
                ev.setOrganisateur_ev(resultSet.getInt(5));
                ev.setLieu_ev(resultSet.getString(6));
                ev.setDisponibilite_ev(resultSet.getString(7));
                ev.setProgramme_ev(resultSet.getString(8));
                ev.setNum_contact(resultSet.getInt(9));
                Evenement.add(ev);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_evenement.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return Evenement;
    }
   
    }
 
