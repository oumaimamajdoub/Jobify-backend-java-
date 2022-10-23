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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    private void ajoutContrat(ActionEvent event) {
        Contrat c=new Contrat();
        c.setType(tfType.getText());  
        c.setDateDebut(Date.valueOf(dpDebut.getValue()));
        c.setDateFin(Date.valueOf(dpFin.getValue()));
        c.setSalaire(Integer.valueOf(tfSalaire.getText()));
        c.setTitre(tftitre.getText());
        pc.ajouter(c);
        refresh();
        
    }

    @FXML
    private void modifierContrat(ActionEvent event) {
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
            refresh();
        }
        
        
       
    }

    @FXML
    private void supprimerContrat(ActionEvent event) {
        
           Contrat c =(Contrat) tableContrat.getSelectionModel().getSelectedItem();
        if(c!=null){
            pc.supprimer(c.getId());
            refresh();
        }
    }
    
     public void refresh(){
        data.clear();
        data=FXCollections.observableArrayList(pc.afficher());
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        tcDateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        tcDateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        tcSalaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        tctitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        tableContrat.setItems(data);
    }
    
    
}
