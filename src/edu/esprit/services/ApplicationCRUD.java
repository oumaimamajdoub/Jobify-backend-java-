/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Application;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.esprit.utils.MyConnection;

/**
 *
 * @author afefz
 */
public class ApplicationCRUD implements IService<Application>{
    Connection Cnx;
    public ApplicationCRUD(){
        Cnx=MyConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(Application A) {
        try {
            String requete ="INSERT INTO application (idPost,idCandidat ,dateApplication) "
                    +"VALUES (?,?,?)";
            PreparedStatement psta = Cnx.prepareStatement(requete);
            psta.setDate(3, (Date) A.getDateApplication());
            psta.setInt(2, A.getIdCandidat());
            psta.setInt(1, A.getIdPost());
            psta.executeUpdate();
            System.out.println("Application ajoutée avec succes");
        
        
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM application WHERE id=?";
            PreparedStatement psta = Cnx.prepareStatement(requete);
            psta.setInt(1, id);
            psta.executeUpdate();
            System.out.println("Application supprimee !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Application A) {
        try {
            String requete = "UPDATE application SET `idPost`=?,`idCandidat`=?,`dateApplication`=? WHERE id=?";
            PreparedStatement psta = Cnx.prepareStatement(requete);
            psta.setInt(1, A.getIdPost());
            psta.setInt(2, A.getIdCandidat());
            psta.setDate(3, (Date) A.getDateApplication());
            psta.setInt(4, A.getId());
           
            psta.executeUpdate();
            System.out.println("Application modifie !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Application> afficher() {
        List<Application>myList = new ArrayList<>();
        try {
            
            String requet2="SELECT * FROM application";
            Statement st = Cnx.prepareStatement(requet2);               
            ResultSet rs = st.executeQuery(requet2);
            while(rs.next()){
                Application A = new Application();
                
                A.setId(rs.getInt(1));
                A.setDateApplication(rs.getDate("dateApplication"));
                A.setIdCandidat(rs.getInt("idCandidat"));
                A.setIdPost(rs.getInt("idPost"));

                myList.add(A);
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
        return myList;
    }
    
}

