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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AjouterUserController implements Initializable {

    
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfage;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmdp;
    @FXML
    private TextField tfnumTel;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfRole;
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
    private void Setadduser(ActionEvent event) {
        
        int age=Integer.parseInt(tfage.getText());
        String nom=tfnom.getText();
        String prenom=tfprenom.getText();
        String email=tfemail.getText();
        String mdp=tfmdp.getText();
        String numTel=tfnumTel.getText();
        String Adresse=tfAdresse.getText();
        String Role=tfRole.getText();
        
        User u = new User(age, nom, prenom, email,  mdp, numTel,  Adresse, Role);
        
        userCRUD uc = new userCRUD();
        
        uc.ajouteruser(u);
        
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AffichageUser.fxml"));
        try {
            Parent root = loader.load();
            AffichageUserController auc= loader.getController();
            auc.setTfnom(u.getNom());
            auc.setTfprenom(u.getPrenom());
            auc.setTfemail(u.getEmail());
            auc.setTfage(""+u.getAge());
            auc.setTfmdp(u.getMdp());
            auc.setTfnumTel(u.getNumTel());
            auc.setTfAdresse(u.getAdresse());
            auc.setTfRole(u.getRole());
            
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
