/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HOMEALLController implements Initializable {

    @FXML
    private Button buttonuser;
    @FXML
    private Button buttoncandidate;
    @FXML
    private Button buttonadmin;
    @FXML
    private Button buttonentrepreneur;
    @FXML
    private Button buttonlogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void touser(ActionEvent event) {
        Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/homeU.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("buttonuser");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        }}

    @FXML
    private void tocandidate(ActionEvent event) {
          Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/HomeC.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("buttoncandidate");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        }}
      
    

    @FXML
    private void toadmin(ActionEvent event) {
         Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/HomeA.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("buttonadmin");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        }}
    

    @FXML
    private void toentrepreneur(ActionEvent event) {
           Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/HomeE.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("buttonentrepreneur");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        }
    }

    @FXML
    private void tologin(ActionEvent event) {
           Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/Log.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("buttonlogin");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        }
    }
    
}
