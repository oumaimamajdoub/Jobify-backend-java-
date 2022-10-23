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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Button butmodif;
    @FXML
    private TableColumn<admin, Integer> cidadmin;
    @FXML
    private Button butSupp;

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
        cidadmin.setCellValueFactory(new PropertyValueFactory<>("id"));
        cemailadmin.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmdpadmin.setCellValueFactory(new PropertyValueFactory<>("mdp"));

        tab.setItems(oblist);
    }
    admin ad= new admin();
    @FXML
    private void getline(MouseEvent event) {
        int index = tab.getSelectionModel().getSelectedIndex();
        ad.setEmail(cemailadmin.getCellData(index).toString());
        ad.setMdp(cmdpadmin.getCellData(index).toString());
        ad.setId(cidadmin.getCellData(index));
        //System.out.println(ad);
    }

    @FXML
    private void tomodifAdmin(ActionEvent event) {
        /*FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AfficherAdmin.fxml"));
        try {
            Parent root = loader.load();
            AfficherAdminController aac= loader.getController();
            
            aac.setTfemail(a.getEmail());
            aac.setTfmdp(a.getMdp());
            
            tfmdp.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }*/
    }

    @FXML
    private void toSuppAdmin(ActionEvent event) {
        us.supprimeradmin(ad.getId());
        tab.getItems().clear();
        loadTableAdmin();
    }
}
