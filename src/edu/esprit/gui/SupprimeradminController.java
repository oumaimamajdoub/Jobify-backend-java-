/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
import edu.esprit.entities.admin;
import edu.esprit.services.adminCRUD;
import edu.esprit.services.userCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SupprimeradminController implements Initializable {

    @FXML
    private TextField tfvalider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimeradmin(ActionEvent event) {
          int id = Integer.parseInt(tfid.getText());
        adminCRUD ac = new adminCRUD();
        admin a = new admin(id);
        uc.supprimeradmin(id);
    }
    
}
