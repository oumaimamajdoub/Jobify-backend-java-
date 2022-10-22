/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.admin;
import edu.esprit.services.adminCRUD;
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
public class HomeAController implements Initializable {

    @FXML
    private TableView<admin> tab;
    @FXML
    private TableColumn<admin, String> cemailadmin;
    @FXML
    private TableColumn<admin, String> cmdpadmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableAdmin();
    }    
    ObservableList<admin> oblist = FXCollections.observableArrayList();

    adminCRUD us = new adminCRUD();

    private void loadTableAdmin() {
        List<admin> fs = us.afficheradmin();
        fs.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        cemailadmin.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmdpadmin.setCellValueFactory(new PropertyValueFactory<>("mdp"));

        tab.setItems(oblist);
    }
}
