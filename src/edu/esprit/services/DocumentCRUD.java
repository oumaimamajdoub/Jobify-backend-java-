/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import edu.esprit.entities.Document;
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
public class DocumentCRUD implements IService<Document>{
    Connection Cnx;
    public DocumentCRUD() {
        Cnx=MyConnection.getInstance().getCnx();
    
    }
    
    

    @Override
    public void ajouter(Document D) {
try {
            String requete ="INSERT INTO document (nom,path ,dateCreation,idContrat ,idCandidat) "
                    +"VALUES (?,?,?,?,?)";
            PreparedStatement pstd = Cnx.prepareStatement(requete);
            pstd.setDate(3, (Date) D.getDateDeCreation());
            pstd.setInt(4, D.getIdContrat());
            pstd.setString(2,D.getPath());
            pstd.setString(1,D.getNom());
            pstd.setInt(5, D.getIdCandidat());
            pstd.executeUpdate();
            System.out.println("Document ajouté avec succes");
        
        
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }   
    }

    @Override
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM document WHERE id=?";
            PreparedStatement pstd = Cnx.prepareStatement(requete);
            pstd.setInt(1, id);
            pstd.executeUpdate();
            System.out.println("Document supprimee !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public void modifier(Document D) {
        try {
            String requete = "UPDATE document SET nom=?,path=?,dateCreation=?,`idContrat`=?,`idCandidat`=?  WHERE id=?";
            PreparedStatement pstd = Cnx.prepareStatement(requete);
            pstd.setInt(6, D.getId());
            pstd.setString(1, D.getNom());
            pstd.setDate(3, D.getDateDeCreation());
            pstd.setString(2, D.getPath());
            pstd.setInt(4, D.getIdContrat());
            pstd.setInt(5, D.getIdCandidat());
            pstd.executeUpdate();
            System.out.println("Document modifie !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public List<Document> afficher() {
        List<Document>myList = new ArrayList<>();
        try {
            
            String requet2="SELECT * FROM document";
            Statement st = Cnx.prepareStatement(requet2);                
            ResultSet rs = st.executeQuery(requet2);
            while(rs.next()){
                Document D = new Document();
                D.setId(rs.getInt(1));
                D.setDateDeCreation(rs.getDate("dateCreation"));
                D.setPath(rs.getString("path"));
                D.setNom(rs.getString("nom"));
                D.setIdCandidat(rs.getInt("idCandidat"));
                D.setIdContrat(rs.getInt("idContrat"));
                myList.add(D);
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
        return myList;    
    }
}

