/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HomeUController implements Initializable {

    @FXML
    private TableView<User> tab;
    @FXML
    private TableColumn<User, String> cnom;
    @FXML
    private TableColumn<User, String> cprenom;
    @FXML
    private TableColumn<User, Integer> cage;
    @FXML
    private TableColumn<User, String> cemail;
    @FXML
    private TableColumn<User, String> cmdp;
    @FXML
    private TableColumn<User, String> cnumtel;
    @FXML
    private TableColumn<User, String> cadd;
    @FXML
    private TableColumn<User, String> crole;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableUser();
    }
    ObservableList<User> oblist = FXCollections.observableArrayList();

    userCRUD us = new userCRUD();

    private void loadTableUser() {
        List<User> fs = us.afficherUser();
        fs.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cage.setCellValueFactory(new PropertyValueFactory<>("age"));
        cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        cnumtel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        cadd.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        crole.setCellValueFactory(new PropertyValueFactory<>("Role"));

        tab.setItems(oblist);
    }
}
