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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modcandidate(ActionEvent event) {
    }
    
}
