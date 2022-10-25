/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Contrat;
import edu.esprit.entities.Post;
import java.net.URL;
import java.sql.Date;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.esprit.services.ContratCRUD;
import edu.esprit.services.PostCRUD;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
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
public class ContratFXMLController implements Initializable {

    @FXML
    private TableView<Contrat> tableContrat;
    @FXML
    private TableColumn<Contrat, String> tcType;
    @FXML
    private TableColumn<Contrat, Date> tcDateDebut;
    @FXML
    private TableColumn<Contrat, Date> tcDateFin;
    @FXML
    private TableColumn<Contrat, Integer> tcSalaire;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfSalaire;
    @FXML
    private Button bt;
    ObservableList<Contrat> data=FXCollections.observableArrayList();
    ContratCRUD pc=new ContratCRUD();
    @FXML
    private DatePicker dpDebut;
    @FXML
    private DatePicker dpFin;
    @FXML
    private TableColumn<Contrat, String> tctitre;
    @FXML
    private TextField tftitre;
    @FXML
    private Button gotogstpost;
    @FXML
    private Button gotogstdocument;
    @FXML
    private Button btTriparTitre;
    @FXML
    private Button bttriparsalaire;
    @FXML
    private TextField tfrecherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh(pc.afficher());
    }  
     public String controleDeSaisie(){
        String erreur="";
        if(tftitre.getText().trim().isEmpty()){
            erreur+="-Remplire le champ titre\n";
        }
        if(tfSalaire.getText().trim().isEmpty()){
            erreur+="-Remplire le champ salaire\n";
        }
        if(tfType.getText().trim().isEmpty()){
            erreur+="-Remplire le champ type\n";
        }
        if(dpDebut.getValue()==null){
            erreur+="-Remplire le champ date du début du contrat\n";
        }
        if(dpFin.getValue()==null){
            erreur+="-Remplire le champ date de fin de contrat\n";
        }
        if(dpFin.getValue().isBefore(dpDebut.getValue())){
            erreur+="-Date incorrect\n";
        }
        if(!tfSalaire.getText().trim().matches("[0-9]+")){
            erreur+="-Inserer correct salaire\n";
        }
        return erreur;
    }


    @FXML
    private void ajoutContrat(ActionEvent event) {
        if(controleDeSaisie().length()>0)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'ajout d'un contrat");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Contrat c=new Contrat();
            c.setType(tfType.getText());  
            c.setDateDebut(Date.valueOf(dpDebut.getValue()));
            c.setDateFin(Date.valueOf(dpFin.getValue()));
            c.setSalaire(Integer.valueOf(tfSalaire.getText()));
            c.setTitre(tftitre.getText());
            pc.ajouter(c);
            /*****************************************************/
             TrayNotification tray=new TrayNotification();
            AnimationType type=AnimationType.POPUP;
            tray.setTitle("Ajout d'un contrat");
            tray.setMessage("Vous avez bien ajouter un contrat");
            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setAnimationType(type);
            tray.showAndDismiss(Duration.seconds(2));
            
        refresh(pc.afficher());
        
            
        }
    }

    @FXML
    private void modifierContrat(ActionEvent event) {
        
          if(controleDeSaisie().length()>0)
        {
               Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de modification d'un contrat");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
          else{
                Contrat selected=(Contrat) tableContrat.getSelectionModel().getSelectedItem();
                     if(selected!=null){
                Contrat c=new Contrat();
                c.setType(tfType.getText());
                c.setTitre(tftitre.getText());

                c.setDateDebut(Date.valueOf(dpDebut.getValue()));
                c.setDateFin(Date.valueOf(dpFin.getValue()));
                c.setSalaire(Integer.valueOf(tfSalaire.getText()));
                c.setId(selected.getId());
                pc.modifier(c);
                 refresh(pc.afficher());
        }
        
          }   
       
    }

    @FXML
    private void supprimerContrat(ActionEvent event) {
        
           Contrat c =(Contrat) tableContrat.getSelectionModel().getSelectedItem();
        if(c!=null){
            pc.supprimer(c.getId());
            refresh(pc.afficher());
        }
    }
    
     public void refresh(List<Contrat> contrats){
        data.clear();
        data=FXCollections.observableArrayList(contrats);
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        tcDateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        tcDateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        tcSalaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        tctitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        tableContrat.setItems(data);
    }
   
    @FXML
    private void triparTitre(ActionEvent event) {
       refresh(pc.triParTitre());
        rechercheavance();
    }
    public void rechercheavance(){
        data=FXCollections.observableArrayList(pc.afficher());
        FilteredList<Contrat> filtredData=new FilteredList<>(data);
        tfrecherche.textProperty().addListener(
                (observable,oldValue,newValue)->{
                    filtredData.setPredicate(contrat->{
                        if(contrat.getTitre().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(contrat.getDateDebut().toString().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(contrat.getDateFin().toString().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(contrat.getType().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(String.valueOf(contrat.getSalaire()).indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        else{
                            return false;
                        }
                    });
                    tableContrat.setItems(filtredData);
                }
                
        );
        
    }

   @FXML
    private void gotogstpost(ActionEvent event) {
        Stage closeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closeStage.close();
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/edu/esprit/gui/postFXML.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Gestion des postes");
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
    private void trisalaire(ActionEvent event) {
        refresh(pc.triParSalaire());
        rechercheavance();
    }
}
    
    

