/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
import edu.esprit.entities.entrepreneur;
import edu.esprit.services.entrepreneurCRUD;
import edu.esprit.services.userCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HomeEController implements Initializable {

    @FXML
    private TableView<entrepreneur> tab;
    @FXML
    private TableColumn<entrepreneur, String> cnome;
    @FXML
    private TableColumn<entrepreneur, String> cemaile;
    @FXML
    private TableColumn<entrepreneur, String> cadde;
    @FXML
    private TableColumn<entrepreneur, String> cmdpe;
    @FXML
    private TableColumn<entrepreneur, String> cnumtele;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableentrepreneur();
    }    
    ObservableList<entrepreneur> oblist = FXCollections.observableArrayList();

    entrepreneurCRUD us = new entrepreneurCRUD();

    private void loadTableentrepreneur() {
        List<entrepreneur> fs = us.afficherentrepreneur();
        fs.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        cnome.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cemaile.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmdpe.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        cnumtele.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        cadde.setCellValueFactory(new PropertyValueFactory<>("Adresse"));

        tab.setItems(oblist);
    }
    
}
