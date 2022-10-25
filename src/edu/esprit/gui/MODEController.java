/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML
    private void modentrepreneur(ActionEvent event) {
    }
    
}
