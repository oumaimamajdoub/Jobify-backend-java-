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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MOFAController implements Initializable {
    @FXML
    private TextField memail;
    @FXML
    private TextField mmdp;
    @FXML
    private Button mbutton;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


  
      
     private void modadmin(ActionEvent event) {
        String email=memail.getText();
        String mdp=mmdp.getText();
        
        admin a = new admin(email,mdp);
        adminCRUD ac = new adminCRUD();
        ac.modifieradmin(a);
        
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("MOFA.fxml"));
        try {
            Parent root = loader.load();
           AfficherAdminController acc= loader.getController();
            
            acc.setTmemail(a.getEmail());
            acc.setTmmdp(a.getMdp());
            
           
        /*    memail.getScene().setRoot(root);*/
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }}

 

