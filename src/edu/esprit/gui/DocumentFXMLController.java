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
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelpath.setVisible(false);
        refresh();
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
        refresh();
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
            refresh();
        }
        
    }

    @FXML
    private void supprimerdocument(ActionEvent event) {
        Document selectedDocument=tabledocument.getSelectionModel().getSelectedItem();
         if(selectedDocument!=null){
             dc.supprimer(selectedDocument.getId());
             refresh();
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
    public void refresh(){
        data.clear();
        data=FXCollections.observableArrayList(dc.afficher());
        tcnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcpath.setCellValueFactory(new PropertyValueFactory<>("path"));
        tcdate.setCellValueFactory(new PropertyValueFactory<>("DateDeCreation"));
        tccontrat.setCellValueFactory(new PropertyValueFactory<>("idContrat"));
        
        tabledocument.setItems(data);
    }
}
