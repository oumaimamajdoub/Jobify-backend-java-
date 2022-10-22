/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AfficherEController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmdp;
    @FXML
    private TextField tfnumTel;
    @FXML
    private TextField tfAdresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setTfemail(String message) {
        this.tfemail.setText(message);
    }
    public void setTfnom(String message) {
        this.tfnom.setText(message);
    }
    public void setTfmdp(String message) {
        this.tfmdp.setText(message);
    }
    public void setTfnumTel(String message) {
        this.tfnumTel.setText(message);
    }
    public void setTfAdresse(String message) {
        this.tfAdresse.setText(message);
    }
}
