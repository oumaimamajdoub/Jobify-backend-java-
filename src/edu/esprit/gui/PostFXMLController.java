/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Post;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.esprit.services.PostCRUD;

/**
 * FXML Controller class
 *
 * @author afefz
 */
public class PostFXMLController implements Initializable {

    @FXML
    private TableView<Post> tablepost;
   
    @FXML
    private TableColumn<Post, String> tcdescription;
    @FXML
    private TableColumn<Post, Date> tcdatecreation;
    @FXML
    private TableColumn<Post, Date> tcdateexpiration;
    @FXML
    private TableColumn<Post, Integer> tcsalaire;
    @FXML
    private TableColumn<Post, Integer> tctitre;
    @FXML
    private TextField tftitre;
    @FXML
    private TextArea tadescription;
    @FXML
    private DatePicker dpcreation;
    @FXML
    private DatePicker dpexpiration;
    @FXML
    private TextField tfsalaire;
    ObservableList<Post> data=FXCollections.observableArrayList();
    PostCRUD pc=new PostCRUD();
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
        
    }    

    @FXML
    private void ajouterPost(ActionEvent event) {
        Post p=new Post();
        p.setTitre(tftitre.getText());
        p.setDescription(tadescription.getText());
        
        p.setDateDeCreation(Date.valueOf(dpcreation.getValue()));
        p.setDateExpiration(Date.valueOf(dpexpiration.getValue()));
        p.setSalaire(Integer.valueOf(tfsalaire.getText()));
        pc.ajouter(p);
        refresh();
        
    }

    @FXML
    private void modifierPost(ActionEvent event) {
        Post pselected=tablepost.getSelectionModel().getSelectedItem();
        if(pselected!=null){
            Post p=new Post();
            p.setTitre(tftitre.getText());
            p.setDescription(tadescription.getText());

            p.setDateDeCreation(Date.valueOf(dpcreation.getValue()));
            p.setDateExpiration(Date.valueOf(dpexpiration.getValue()));
            p.setSalaire(Integer.valueOf(tfsalaire.getText()));
            p.setId(pselected.getId());
            pc.modifier(p);
            refresh();
        }
        
    }

    @FXML
    private void supprimerPost(ActionEvent event) {
        Post p=tablepost.getSelectionModel().getSelectedItem();
        if(p!=null){
            pc.supprimer(p.getId());
            refresh();
        }
        
        
    }
    public void refresh(){
        data.clear();
        data=FXCollections.observableArrayList(pc.afficher());
        tctitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        tcdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcdatecreation.setCellValueFactory(new PropertyValueFactory<>("dateDeCreation"));
        tcdateexpiration.setCellValueFactory(new PropertyValueFactory<>("dateExpiration"));
        tcsalaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        tablepost.setItems(data);
    }
    
}
