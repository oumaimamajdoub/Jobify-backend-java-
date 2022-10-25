/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
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
public class MOFUController implements Initializable {

    private String mail;
    @FXML
    private TextField mnomu;
    @FXML
    private TextField mprenomu;
    @FXML
    private TextField mageu;
    @FXML
    private TextField memailu;
    @FXML
    private TextField mmdpu;
    @FXML
    private TextField mnumtelu;
    @FXML
    private TextField madresseu;
    @FXML
    private TextField mroleu;
    @FXML
    private Button mmodifier;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    
    
    public void setmnom(String message) {
        this.mnomu.setText(message);
    }
    public void setmprenom(String message) {
        this.mprenomu.setText(message);
    }
    public void setmage(String message) {
        this.mageu.setText(message);
    }
    public void setmemail(String message) {
        this.memailu.setText(message);
    }
    public void setmmdp(String message) {
        this.mmdpu.setText(message);
    }
    public void setmadd(String message) {
        this.madresseu.setText(message);
    }
    public void setmrole(String message) {
        this.mroleu.setText(message);
    }
    public void setmnumtel(String message) {
        this.mnumtelu.setText(message);
    }
    @FXML
    private void valModU(ActionEvent event) {
        
        int age=Integer.parseInt(mageu.getText());
        String nom=mnomu.getText();
        String prenom=mprenomu.getText();
        String email=memailu.getText();
        String mdp=mmdpu.getText();
        String numTel=mnumtelu.getText();
        String Adresse=madresseu.getText();
        String Role=mroleu.getText();
        
        User u = new User(age, nom, prenom, email,  mdp, numTel,  Adresse, Role);
        
        userCRUD uc = new userCRUD();
        
        uc.modifierUser(email, u);
        
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("HomeU.fxml"));
        try {
            Parent root = loader.load();
            
            
            mnomu.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
