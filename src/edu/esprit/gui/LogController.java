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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LogController implements Initializable {

    @FXML
    private TextField Lmail;
    @FXML
    private PasswordField Lmdp;
    @FXML
    private Label errLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    

    @FXML
    private void Login(ActionEvent event) throws SQLException {
        String mdp = Lmdp.getText();
        String Email = Lmail.getText();
        userCRUD us = new userCRUD();
        User ul = new User(Email, mdp);
        User ug = new User();
        ug = us.login(ul);
        System.out.println(ug);
        if (ug.getId()> 0) {
            
            
            FXMLLoader loader
                    = new FXMLLoader(getClass().getResource("HomeU.fxml"));
            try {
                Parent root = loader.load();
                Lmail.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            errLogin.setText("mail ou mdp incorrect");
        }
    }

    @FXML
    private void mdpO(ActionEvent event) {
        FXMLLoader loader
                    = new FXMLLoader(getClass().getResource("ObliMDP.fxml"));
            try {
                Parent root = loader.load();
                Lmail.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
}
