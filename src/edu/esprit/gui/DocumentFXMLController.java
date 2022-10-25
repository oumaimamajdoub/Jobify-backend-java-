/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Document;
import edu.esprit.entities.Post;
import edu.esprit.services.ContratCRUD;
import edu.esprit.services.DocumentCRUD;
import edu.esprit.services.PostCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
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
public class DocumentFXMLController implements Initializable {

    @FXML
    private TableView<Document> tabledocument;
    @FXML
    private TableColumn<Document, String> tcnom;
    @FXML
    private TableColumn<Document, String> tcpath;
    @FXML
    private TableColumn<Document, Date> tcdate;
    @FXML
    private TableColumn<Document, Integer> tccontrat;
    @FXML
    private DatePicker dpdatecreation;
    @FXML
    private ComboBox<String> cbcontrat;
    @FXML
    private Label labelpath;
    ObservableList<Document> data=FXCollections.observableArrayList();
    ObservableList<String> datacb=FXCollections.observableArrayList();
    DocumentCRUD dc=new DocumentCRUD();
    ContratCRUD cc=new ContratCRUD();
    @FXML
    private TextField tfnom;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button gotogstpost;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button gotogscontrat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelpath.setVisible(false);
        refresh(dc.afficher());
        datacb=FXCollections.observableArrayList(cc.getAllContratTitle());
        cbcontrat.setItems(datacb);
    }    

    @FXML
    private void ajouterdocument(ActionEvent event) {
        Document d=new Document();
        d.setNom(tfnom.getText());
        d.setPath(labelpath.getText());
        d.setDateDeCreation(Date.valueOf(dpdatecreation.getValue()));
        d.setIdContrat(cc.getIdContratByTitre(cbcontrat.getSelectionModel().getSelectedItem()));
        d.setIdCandidat(22);
        dc.ajouter(d);
        refresh(dc.afficher());
    }
    
   
    @FXML
    private void modifierdocument(ActionEvent event) {
        Document selectedDocument=tabledocument.getSelectionModel().getSelectedItem();
        if(selectedDocument!=null){
            Document d=new Document();
            d.setNom(tfnom.getText());
            d.setPath(labelpath.getText());
            d.setDateDeCreation(Date.valueOf(dpdatecreation.getValue()));
            d.setIdContrat(cc.getIdContratByTitre(cbcontrat.getSelectionModel().getSelectedItem()));
            d.setIdCandidat(22);
            d.setId(selectedDocument.getId());
            dc.modifier(d);
            refresh(dc.afficher());
        }
        
    }

    @FXML
    private void supprimerdocument(ActionEvent event) {
        Document selectedDocument=tabledocument.getSelectionModel().getSelectedItem();
         if(selectedDocument!=null){
             dc.supprimer(selectedDocument.getId());
             refresh(dc.afficher());
         }
    }

    @FXML
    private void uploaddocument(ActionEvent event) {
        FileChooser open=new FileChooser();
        Stage stage=(Stage) anchor.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null){
            String path=file.getAbsolutePath();
            labelpath.setText(path);
        }
    }
    public void refresh(List<Document> document){
        data.clear();
        data=FXCollections.observableArrayList(document);
        tcnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcpath.setCellValueFactory(new PropertyValueFactory<>("path"));
        tcdate.setCellValueFactory(new PropertyValueFactory<>("DateDeCreation"));
        tccontrat.setCellValueFactory(new PropertyValueFactory<>("idContrat"));
        
        tabledocument.setItems(data);
    }
    
    
    
    public void rechercheavance(){
        data=FXCollections.observableArrayList(dc.afficher());
        FilteredList<Document> filtredData=new FilteredList<>(data);
        tfrecherche.textProperty().addListener(
                (observable,oldValue,newValue)->{
                    filtredData.setPredicate(document->{
                        if(document.getNom().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(document.getDateDeCreation().toString().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        
                        if(document.getPath().toLowerCase().indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        if(String.valueOf(document.getId()).indexOf(newValue.toLowerCase())!=-1){
                            return true;
                        }
                        else{
                            return false;
                        }
                    });
                    tabledocument.setItems(filtredData);
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
    private void triparnom(ActionEvent event) {
        
        refresh(dc.triParNom());
        rechercheavance();
    }
}
    


    
    
    
    
    
    
    

