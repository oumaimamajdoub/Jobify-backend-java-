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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    @FXML
    private TextField tfrecherche;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh(pc.afficher());
        rechercheavance();
        
    }    
    public String controleDeSaisie(){
        String erreur="";
        if(tftitre.getText().trim().isEmpty()){
            erreur+="-Remplire le champ titre\n";
        }
        if(tfsalaire.getText().trim().isEmpty()){
            erreur+="-Remplire le champ salaire\n";
        }
        if(tadescription.getText().trim().isEmpty()){
            erreur+="-Remplire le champ description\n";
        }
        if(dpcreation.getValue()==null){
            erreur+="-Remplire le champ date de creation\n";
        }
        if(dpexpiration.getValue()==null){
            erreur+="-Remplire le champ date d'expiration\n";
        }
        if(dpexpiration.getValue().isBefore(dpcreation.getValue())){
            erreur+="-Date incorrect\n";
        }
        if(!tfsalaire.getText().trim().matches("[0-9]+")){
            erreur+="-Inserer correct salaire\n";
        }
        return erreur;
    }

    @FXML
    private void ajouterPost(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'ajout d'une post");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Post p=new Post();
            p.setTitre(tftitre.getText());
            p.setDescription(tadescription.getText());

            p.setDateDeCreation(Date.valueOf(dpcreation.getValue()));
            p.setDateExpiration(Date.valueOf(dpexpiration.getValue()));
            p.setSalaire(Integer.valueOf(tfsalaire.getText()));
            pc.ajouter(p);
            
           //Notification********************************
            TrayNotification tray=new TrayNotification();
            AnimationType type=AnimationType.POPUP;
            tray.setTitle("Ajout d'une poste");
            tray.setMessage("Vous avez bien ajouter un poste");
            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setAnimationType(type);
            tray.showAndDismiss(Duration.seconds(2));
        //****************************************************
        
            refresh(pc.afficher());
            rechercheavance();
        }
        
        
    }

    @FXML
    private void modifierPost(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur modification d'une post");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
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
                refresh(pc.afficher());
                rechercheavance();
            }
        }
        
        
    }

    @FXML
    private void supprimerPost(ActionEvent event) {
        Post p=tablepost.getSelectionModel().getSelectedItem();
        if(p!=null){
            pc.supprimer(p.getId());
            refresh(pc.afficher());
            rechercheavance();
        }
        
        
    }
    public void refresh(List<Post> posts){
        data.clear();
        data=FXCollections.observableArrayList(posts);
        tctitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        tcdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcdatecreation.setCellValueFactory(new PropertyValueFactory<>("dateDeCreation"));
        tcdateexpiration.setCellValueFactory(new PropertyValueFactory<>("dateExpiration"));
        tcsalaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        tablepost.setItems(data);
    }

    @FXML
    private void triparsalaire(ActionEvent event) {
        refresh(pc.triParSalaire());
        rechercheavance();
    }

    @FXML
    private void tripartitre(ActionEvent event) {
        refresh(pc.triParTitre());
        rechercheavance();
    }
    public void rechercheavance(){
        data=FXCollections.observableArrayList(pc.afficher());
        FilteredList<Post> filtredData=new FilteredList<>(data);
        tfrecherche.textProperty().addListener(
                (observable,oldValue,newValue)->{
                    filtredData.setPredicate(post->{
                        if(post.getTitre().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(post.getDateDeCreation().toString().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(post.getDateExpiration().toString().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(post.getDescription().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(String.valueOf(post.getSalaire()).indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        else{
                            return false;
                        }
                    });
                    tablepost.setItems(filtredData);
                }
                
        );
        
    }

    @FXML
    private void gotogstcontrat(ActionEvent event) {
        Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/ContratFXML.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Gestion contrat");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PostFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotogstdocument(ActionEvent event) {
        Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/documentFXML.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Gestion document");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PostFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotostatistique(ActionEvent event) {
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/stat_application_postFXML.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Gestion contrat");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PostFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
