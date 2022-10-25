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
public class MODEController implements Initializable {

    @FXML
    private TextField mnome;
    @FXML
    private TextField memaile;
    @FXML
    private TextField mmdpe;
    @FXML
    private TextField mnumtele;
    @FXML
    private TextField madressee;
    @FXML
    private Button mode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setmemail(String message) {
        this.memaile.setText(message);
    }
    public void setmmdp(String message) {
        this.mmdpe.setText(message);
    }
    public void setmnom(String message) {
        this.mnome.setText(message);
    }
     public void setmadd(String message) {
        this.madressee.setText(message);
    }
    
    public void setmnumtel(String message) {
        this.mnumtele.setText(message);
    }
    
    
    
    
    @FXML
    private void modentrepreneur(ActionEvent event) {
        
        String nom=mnome.getText();
        String email=memaile.getText();
        String mdp=mmdpe.getText();
        String numTel=mnumtele.getText();
        String Adresse=madressee.getText();
        
        entrepreneur u = new entrepreneur( nom,email,  mdp, numTel,  Adresse);
        
        entrepreneurCRUD uc = new entrepreneurCRUD();
        
        uc.modifierentrepreneur(email, u);
        
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("HomeE.fxml"));
        try {
            Parent root = loader.load();
            
            
            mnome.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    }
    

