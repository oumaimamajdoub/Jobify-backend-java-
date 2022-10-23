/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import edu.esprit.entities.Contrat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.esprit.utils.MyConnection;
import java.util.List;

/**
 *
 * @author afefz
 */
public class ContratCRUD implements IService<Contrat>{
    Connection Cnx;
    public ContratCRUD() {
        
        
        Cnx=MyConnection.getInstance().getCnx();
    
    }
    

    @Override
    public void ajouter(Contrat C) {
        try {
            String requete ="INSERT INTO contrat (type,dateDebut,dateFin ,salaire) "
                    +"VALUES (?,?,?,?)";
            PreparedStatement pstc = Cnx.prepareStatement(requete);
            pstc.setDate(2, (Date) C.getDateDebut());
            pstc.setDate(3, (Date) C.getDateFin());
            pstc.setString(1,C.getType());
            pstc.setInt(4, C.getSalaire());
            pstc.executeUpdate();
            System.out.println("Contrat ajouté avec succes");
        
        
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());       
        }    
    }

    @Override
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM contrat WHERE id=?";
            PreparedStatement pstc = Cnx.prepareStatement(requete);
            pstc.setInt(1, id);
            pstc.executeUpdate();
            System.out.println("Contrat supprime !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public void modifier(Contrat C) {
        try {
            String requete = "UPDATE contrat SET type=?,datedebut=?,datefin=?,salaire=?  WHERE id=?";
            PreparedStatement pstc = Cnx.prepareStatement(requete);
            pstc.setInt(5, C.getId());
            pstc.setDate(2, C.getDateDebut());
            pstc.setDate(3, C.getDateFin());
            pstc.setString(1, C.getType());
            pstc.setInt(4, C.getSalaire());
            pstc.executeUpdate();
            System.out.println("Contrat modifie !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public List<Contrat> afficher() {
        List<Contrat>myList = new ArrayList<>();
        try {
            
            String requet2="SELECT * FROM contrat";
            Statement st = Cnx.prepareStatement(requet2);               
            ResultSet rs = st.executeQuery(requet2);
            while(rs.next()){
                Contrat C = new Contrat();
                C.setId(rs.getInt(1));
                C.setDateDebut(rs.getDate("dateDebut"));
                C.setDateFin(rs.getDate("dateFin"));
                
                C.setType(rs.getNString("type"));
                C.setSalaire(rs.getInt("salaire"));
                myList.add(C);
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
        return myList;
    }
}

