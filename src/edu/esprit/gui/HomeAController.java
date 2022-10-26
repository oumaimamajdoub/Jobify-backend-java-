/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.admin;
import edu.esprit.entities.candidate;
import edu.esprit.services.adminCRUD;
import edu.esprit.services.candidateCRUD;
import java.io.IOException;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HomeAController implements Initializable {

    @FXML
    private AnchorPane tableadmin;
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
    @FXML
    private TableView<admin> tab;
    @FXML
    private TextField idCher;
    @FXML
    private Button AJOUTERA;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
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
    admin ad = new admin();

    @FXML
    private void getline(MouseEvent event) {
        int index = tab.getSelectionModel().getSelectedIndex();
        ad.setEmail(cemailadmin.getCellData(index));
        ad.setMdp(cmdpadmin.getCellData(index));
        ad.setId(cidadmin.getCellData(index));
        //System.out.println(ad);
    }

    @FXML
    private void tomodifAdmin(ActionEvent event) {
        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("MOFA.fxml"));
        try {
            Parent root = loader.load();
            MOFAController auc = loader.getController();
            auc.setmemail(ad.getEmail());
            auc.setmmdp(ad.getMdp());

            tab.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void toSuppAdmin(ActionEvent event) {
        us.supprimeradmin(ad.getId());
        tab.getItems().clear();
        loadTableAdmin();
          Notifications.create().title("NOTIFICATIONS")
                    .text("user supprimer")
                    .showInformation();
    
    }

    @FXML
    private void cher(ActionEvent event) {
        int id =Integer.parseInt(idCher.getText()) ;
         tab.getItems().clear();
         adminCRUD ec = new adminCRUD();
         List<admin> fs = ec.afficheradminbyId(id);
        fs.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        cidadmin.setCellValueFactory(new PropertyValueFactory<>("id"));
        cemailadmin.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmdpadmin.setCellValueFactory(new PropertyValueFactory<>("mdp"));

        tab.setItems(oblist);
    }

    @FXML
    private void toadda(ActionEvent event) {
         FXMLLoader loader =
                new FXMLLoader(getClass().getResource("Ajouteradmin.fxml"));
        try {
            Parent root = loader.load();
           
            
            tab.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
