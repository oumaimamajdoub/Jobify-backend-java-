/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.candidate;
import edu.esprit.entities.entrepreneur;
import edu.esprit.services.candidateCRUD;
import edu.esprit.services.entrepreneurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterentrepController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmdp;
    @FXML
    private TextField tfnumTel;
    @FXML
    private TextField tfAdresse;
    @FXML
    private Button tfValider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addentrep(ActionEvent event) {
        
         
        String nom = tfnom.getText();
        
        String email = tfemail.getText();
        String mdp = tfmdp.getText();
        String numTel = tfnumTel.getText();
        String Adresse = tfAdresse.getText();
        //(String nom, String email, String mdp, String numTel, String Adresse)
        entrepreneur e= new entrepreneur( nom, email, mdp, numTel, Adresse);
        entrepreneurCRUD ec = new entrepreneurCRUD();
        ec.ajouterentrepreneur(e);

        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("AfficherE.fxml"));
        try {
            Parent root = loader.load();

            AfficherEController acc = loader.getController();
            acc.setTfnom(e.getNom());
            acc.setTfemail(e.getEmail());
            acc.setTfmdp(e.getMdp());
            acc.setTfnumTel(e.getNumTel());
            acc.setTfAdresse(e.getAdresse());

            tfnom.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.print(ex.getMessage());

        }
    
    }
    
}
