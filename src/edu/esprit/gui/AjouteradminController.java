/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.admin;
import edu.esprit.services.adminCRUD;
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
public class AjouteradminController implements Initializable {

    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmdp;
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
    private void Setaddadmin(ActionEvent event) {
        String email=tfemail.getText();
        String mdp=tfmdp.getText();
        
        admin a = new admin(email,mdp);
        adminCRUD ac = new adminCRUD();
        ac.ajouteradmin(a);
        
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AfficherAdmin.fxml"));
        try {
            Parent root = loader.load();
            AfficherAdminController aac= loader.getController();
            
            aac.setTfemail(a.getEmail());
            aac.setTfmdp(a.getMdp());
            
            tfmdp.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
