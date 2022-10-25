/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
import edu.esprit.entities.candidate;
import edu.esprit.services.candidateCRUD;
import edu.esprit.services.userCRUD;
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
public class MOFCController implements Initializable {

    @FXML
    private TextField mnomc;
    @FXML
    private TextField mprenomc;
    @FXML
    private TextField magec;
    @FXML
    private TextField memailc;
    @FXML
    private TextField mmdpc;
    @FXML
    private TextField mnumtelc;
    @FXML
    private TextField madressec;
    @FXML
    private Button cmodifier;

    public void setmnom(String message) {
        this.mnomc.setText(message);
    }
    public void setmprenom(String message) {
        this.mprenomc.setText(message);
    }
    public void setmage(String message) {
        this.magec.setText(message);
    }
    public void setmemail(String message) {
        this.memailc.setText(message);
    }
    public void setmmdp(String message) {
        this.mmdpc.setText(message);
    }
    public void setmadd(String message) {
        this.madressec.setText(message);
    }
    
    public void setmnumtel(String message) {
        this.mnumtelc.setText(message);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modcandidate(ActionEvent event) {
        int age=Integer.parseInt(magec.getText());
        String nom=mnomc.getText();
        String prenom=mprenomc.getText();
        String email=memailc.getText();
        String mdp=mmdpc.getText();
        String numTel=mnumtelc.getText();
        String Adresse=madressec.getText();
        
        candidate u = new candidate(age, nom, prenom, email,  mdp, numTel,  Adresse);
        
        candidateCRUD uc = new candidateCRUD();
        
        uc.modifiercandidate(email, u);
        
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("HomeC.fxml"));
        try {
            Parent root = loader.load();
            
            
            mnomc.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
