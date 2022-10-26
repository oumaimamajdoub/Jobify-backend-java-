/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.User;
import edu.esprit.entities.candidate;
import edu.esprit.entities.entrepreneur;
import edu.esprit.services.candidateCRUD;
import edu.esprit.services.userCRUD;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

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
    @FXML
    private TextField idchercher;

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
          Notifications.create().title("NOTIFICATIONS")
                    .text("Candidat supprimer")
                    .showInformation();
    }
        
    

    @FXML
    private void ModC(ActionEvent event) {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("MOFC.fxml"));
        try {
            Parent root = loader.load();
            MOFCController auc= loader.getController();
            auc.setmnom(ca.getNom());
            auc.setmprenom(ca.getPrenom());
            auc.setmemail(ca.getEmail());
            auc.setmage(""+ca.getAge());
            auc.setmmdp(ca.getMdp());
            auc.setmnumtel(ca.getNumTel());
            auc.setmadd(ca.getAdresse());
            //auc.setMail(uu.getEmail());
            
            tab.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        
        }}

    @FXML
    private void cher(ActionEvent event) {
        int id =Integer.parseInt(idchercher.getText()) ;
         tab.getItems().clear();
         candidateCRUD ec = new candidateCRUD();
         List<candidate> fs = ec.affichercandidatebyId(id);
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
}

