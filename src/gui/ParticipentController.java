/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evenement;
import entities.Participant;
import static gui.EvenementController.selectedItemm;
import java.net.URL;
import java.sql.Connection;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import services.Service_evenement;
import services.Service_participants;
import utils.Myconnection;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ParticipentController implements Initializable {

    @FXML
    private Label tfidparticipant;
    @FXML
    private Label tfidevenemnt;
    @FXML
    private Label tfiduser;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private Button ajout_souha;
    @FXML
    private Button modifier_souha;
    @FXML
    private Button supprimer_souha;
    @FXML
   private TableView<Participant> tfparticipant;
    @FXML
    private TableColumn<Participant,Integer> colidparticipant;
    @FXML
    private TableColumn<Participant,Integer> coliduser;
     @FXML
    private TableColumn<Participant,Integer> colevenement;
    @FXML
    private Label participant;
    @FXML
    private Label tfid;
    static Participant selectedItemm;
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
        
        Myconnection conn = new Myconnection();
        Connection cnx = conn.getCnx();
        refresh();
        loadTablevent();
    }    
 ObservableList<Participant> oblist = FXCollections.observableArrayList();
        Service_participants  ps = new  Service_participants ();

    ObservableList<Participant> oblistP = FXCollections.observableArrayList();
        Service_participants  sp = new  Service_participants ();
    
/* private void loadTablevent() {
        List<Participant> ls  = ps.afficher();
       colidparticipant.setCellValueFactory(new PropertyValueFactory<>("Id_participant"));
        colevenement.setCellValueFactory(new PropertyValueFactory<>("Id_Evenement"));
        coliduser.setCellValueFactory(new PropertyValueFactory<>("Id_User"));
        tfparticipant.setItems(oblistP);

 }*/
 private void loadTablevent() {
      Service_participants  pr = new  Service_participants ();
        
        ObservableList<Participant> oblistP = pr.afficher();
        
        System.out.println(oblist);
       colidparticipant.setCellValueFactory(new PropertyValueFactory<>("id_pr"));
        colevenement.setCellValueFactory(new PropertyValueFactory<>("id_ev"));
        coliduser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        tfparticipant.setItems(oblistP);
    }
      
    @FXML
    private void ajouter(ActionEvent event) {
        Integer IdParticipant_pr= Integer.valueOf(tf1.getText());
        Integer IdEvenement_pr= Integer.valueOf(tf2.getText());
        Integer IdUser_pr= Integer.valueOf(tf3.getText());
        Participant p =new Participant();
        p.setId_pr(IdParticipant_pr);
        p.setId_ev(IdEvenement_pr);
        p.setId_user(IdUser_pr);
        sp.ajouter(p);
        loadTablevent();
    }
   
    @FXML
    private void modifier(ActionEvent event) throws Exception  {
       Participant p =new Participant();
       Service_participants  pr = new  Service_participants ();
       p.setId_pr(Integer.valueOf(tf1.getText()));
        p.setId_ev(Integer.valueOf(tf2.getText()));
        p.setId_user(Integer.valueOf(tf3.getText()));
        sp.modifier(p);
        loadTablevent();
    }
    @FXML
    private void supprimer(ActionEvent event)throws Exception {
        Participant p = tfparticipant.getSelectionModel().getSelectedItem();
        sp.Supprimer(p);
        tfparticipant.getItems().clear();
        JOptionPane.showMessageDialog(null,"Participant supprimé"); 
            loadTablevent();
        loadTablevent();
    }

    @FXML
    private void index(MouseEvent event) {
       Participant p = tfparticipant.getSelectionModel().getSelectedItem();
       tf1.setText(Integer.toString(p.getId_pr()));
       tf2.setText(Integer.toString(p.getId_ev()));
       tf3.setText(Integer.toString(p.getId_user()));
    }
 
    
}
