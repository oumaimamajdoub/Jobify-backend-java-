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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

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
    private TextField test;
    @FXML
    private Button butmodif;
    @FXML
    private Button butmodif1;

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
    

    entrepreneur ee=new entrepreneur();
    @FXML
    private void getdata(MouseEvent event) {
        int index = tab.getSelectionModel().getSelectedIndex();
        ee.setEmail(cemaile.getCellData(index));
        ee.setAdresse(cadde.getCellData(index));
        ee.setNumTel(cnumtele.getCellData(index));
        ee.setMdp(cmdpe.getCellData(index));
        ee.setNom(cnome.getCellData(index));
    }

    @FXML
    private void tosuppE(ActionEvent event) {
        us.supprimerentrepreneurByEmail(ee.getEmail());
        tab.getItems().clear();
        loadTableentrepreneur();
    }

    @FXML
    private void tomodif(ActionEvent event) {
         FXMLLoader loader =
                new FXMLLoader(getClass().getResource("MODE.fxml"));
        try {
            Parent root = loader.load();
            MODEController auc= loader.getController();
            auc.setmnom(ee.getNom());
            auc.setmemail(ee.getEmail());
            auc.setmmdp(ee.getMdp());
            auc.setmnumtel(ee.getNumTel());
            auc.setmadd(ee.getAdresse());
 
            //auc.setMail(uu.getEmail());
            
            tab.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }


    
}
