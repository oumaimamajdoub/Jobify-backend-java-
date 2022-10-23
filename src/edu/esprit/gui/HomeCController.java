/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
import edu.esprit.entities.candidate;
import edu.esprit.services.candidateCRUD;
import edu.esprit.services.userCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HomeCController implements Initializable {

    @FXML
    private TableView<candidate> tab;
    @FXML
    private TableColumn<candidate, String> cnomc;
    @FXML
    private TableColumn<candidate, String> cprenomc;
    @FXML
    private TableColumn<candidate, Integer> cagec;
    @FXML
    private TableColumn<candidate, String> cemailc;
    @FXML
    private TableColumn<candidate, String> cmdpc;
    @FXML
    private TableColumn<candidate, String> caddc;
    @FXML
    private TableColumn<candidate, String> cnumtelc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableCandidate();
    }    
    ObservableList<candidate> oblist = FXCollections.observableArrayList();

    candidateCRUD us = new candidateCRUD();

    private void loadTableCandidate() {
        List<candidate> fs = us.affichercandidate();
        fs.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        cnomc.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cprenomc.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cagec.setCellValueFactory(new PropertyValueFactory<>("age"));
        cemailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmdpc.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        cnumtelc.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        caddc.setCellValueFactory(new PropertyValueFactory<>("Adresse"));

        tab.setItems(oblist);
    }
    candidate ca =new candidate();
    @FXML
    private void getdata(MouseEvent event) {
        int index = tab.getSelectionModel().getSelectedIndex();
        ca.setEmail(cemailc.getCellData(index));
        ca.setAdresse(caddc.getCellData(index));
        ca.setNumTel(cnumtelc.getCellData(index));
        ca.setAge(cagec.getCellData(index));
        ca.setMdp(cmdpc.getCellData(index));
        ca.setNom(cnomc.getCellData(index));
        ca.setPrenom(cprenomc.getCellData(index));
    }

    @FXML
    private void suppC(ActionEvent event) {
        us.supprimercandidateByEmail(ca.getEmail());
        tab.getItems().clear();
        loadTableCandidate();
        
    }
}
