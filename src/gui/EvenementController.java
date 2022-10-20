/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evenement;
import entities.Participant;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import services.Service_evenement;
import services.Service_participants;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EvenementController implements Initializable {

    @FXML
    private TableColumn<Evenement, Integer> a_idevent;
    @FXML
    private TableColumn<Evenement, String> a_nomevent;
    @FXML
    private TableColumn<Evenement, String> a_programmevent;
    @FXML
    private TableColumn<Evenement, String> a_lieuevent;
    @FXML
    private TableColumn<Evenement, String> a_numcontacts;
    @FXML
    private TableColumn<Evenement, String> a_disponibiliteevent;
    @FXML
    private TableColumn<Evenement, DatePicker> a_datedebutevent;
    @FXML
    private TableColumn<Evenement, DatePicker> a_datefinevent;
    @FXML
    private TableColumn<Evenement, String> a_nomevent7;
    @FXML
    private TableColumn<Evenement, String> a_organisateurevent;
    @FXML
    private TableView<Evenement> Evenenemt_table;
    @FXML
    private Button b_ajouter_event;
    @FXML
    private DatePicker date_db;
    @FXML
    private TextField txt_nom_event;
    @FXML
    private TextField txt_programe_event;
    @FXML
    private TextField txt_organisateur;
    @FXML
    private TextField txt_lieu;
    @FXML
    private TextField txt_num;
    @FXML
    private TextField txt_dispo;
    @FXML
    private DatePicker dateend;
    @FXML
    private TableColumn<Participant, Integer> Id_participant;
    @FXML
    private TableColumn<Participant, Integer> Id_evenement;
    @FXML
    private TableColumn<Participant, Integer> id_user;
    @FXML
    private Button b_ajotuer_participant;
    @FXML
    private TextField txt_id_pr;
    @FXML
    private TextField txt_id_ev;
    @FXML
    private TextField txt_id_user;
    @FXML
    private TableView<Participant> table_participant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTablevent();
        loattableParticipant();
    }
    ObservableList<Evenement> oblist = FXCollections.observableArrayList();
    Service_evenement es = new Service_evenement();

    ObservableList<Participant> oblistP = FXCollections.observableArrayList();
    Service_participants ps = new Service_participants();

    private void loadTablevent() {//affiche EVENT
        List<Evenement> ls = es.afficher();
        ls.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        a_idevent.setCellValueFactory(new PropertyValueFactory<>("id_ev "));
        a_nomevent.setCellValueFactory(new PropertyValueFactory<>("nom_ev"));
        a_programmevent.setCellValueFactory(new PropertyValueFactory<>("programme_ev"));
        a_organisateurevent.setCellValueFactory(new PropertyValueFactory<>("organisateur_ev"));
        a_lieuevent.setCellValueFactory(new PropertyValueFactory<>("lieu_ev"));
        a_disponibiliteevent.setCellValueFactory(new PropertyValueFactory<>("disponibilite_ev"));
        a_datedebutevent.setCellValueFactory(new PropertyValueFactory<>("date_debut_ev"));
        a_datefinevent.setCellValueFactory(new PropertyValueFactory<>("date_fin_ev"));
        a_numcontacts.setCellValueFactory(new PropertyValueFactory<>("num_contact"));
        Evenenemt_table.setItems(oblist);
    }

    private void loattableParticipant() {//affiche pARTICIPANT
        List<Participant> ls = ps.afficher();
        ls.forEach(e -> oblistP.add(e));
        System.out.println(oblistP);
        id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Id_participant.setCellValueFactory(new PropertyValueFactory<>("id_participant"));
        Id_evenement.setCellValueFactory(new PropertyValueFactory<>("id_ev "));
        table_participant.setItems(oblistP);
    }

    @FXML
    private void event_supp(MouseEvent event) {
        Evenement e = Evenenemt_table.getSelectionModel().getSelectedItem();
        es.Supprimer(e);
        Evenenemt_table.getItems().clear();
        loadTablevent();
    }

    @FXML
    private void ajouter_event(ActionEvent event) {

        if (txt_dispo.getText().equals("") || txt_lieu.getText().equals("") || txt_nom_event.getText().equals("") || txt_num.getText().equals("") || txt_organisateur.getText().equals("") || txt_programe_event.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir tout les champs ");
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date datestart = Date.valueOf(date_db.getValue());
            java.sql.Date dateend = Date.valueOf(this.dateend.getValue());

            if (datestart.compareTo(dateend) > 0) {
                JOptionPane.showMessageDialog(null, "veuiller remplir avec parametre reel");
            } else {
                int nbr1 = Integer.parseInt(txt_organisateur.getText());
                int nbr2 = Integer.parseInt(txt_num.getText());

                Evenement h = new Evenement(txt_nom_event.getText(), datestart, dateend, nbr1, txt_lieu.getText(), txt_dispo.getText(), txt_programe_event.getText(), nbr2);
                es.ajouter(h);
                Evenenemt_table.getItems().clear();
                loadTablevent();
            }
        }
    }

    @FXML
    private void event_select(MouseEvent event) {
        int index = Evenenemt_table.getSelectionModel().getSelectedIndex();
        Evenement h = Evenenemt_table.getSelectionModel().getSelectedItem();

        txt_nom_event.setText(a_nomevent.getCellData(index));
        txt_programe_event.setText(a_programmevent.getCellData(index));
        txt_lieu.setText(a_lieuevent.getCellData(index));
        txt_dispo.setText(a_disponibiliteevent.getCellData(index));
        txt_num.setText(a_numcontacts.getCellData(index));
        txt_organisateur.setText(a_organisateurevent.getCellData(index));
    }

    @FXML
    private void ajouter_participant(ActionEvent event) {

    }

    @FXML
    private void modifer_participant(ActionEvent event) {
    }

    @FXML
    private void supprimer_participant(MouseEvent event) {
        Participant e = (Participant) table_participant.getSelectionModel().getSelectedItem();
        ps.Supprimer(e);
        table_participant.getItems().clear();
        loattableParticipant();
    }

}
