/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication;

import entities.Network;
import entities.Profil;
import java.net.URL;
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
import services.NetworkCRUD;
import services.ProfilCRUD;









/**
 * FXML Controller class
 *
 * @author Ismail
 */
public class Inscription2Controller implements Initializable {

    @FXML
    private TextField isfnom;
    @FXML
    private Label isnom;
    @FXML
    private Label isprenom;
    @FXML
    private Label isaddresse;
    @FXML
    private Label iscode;
    @FXML
    private Label isnationalite;
    @FXML
    private Label isphone;
    @FXML
    private Label issexe;
    @FXML
    private Label iscompetences;
    @FXML
    private Label islanguage;
    @FXML
    private Label isentreprise;
    @FXML
    private Label isecole;
    @FXML
    private Label islinkdin;
    @FXML
    private Label isgithub;
    @FXML
    private TextField isfprenom;
    @FXML
    private TextField isfaddresse;
    @FXML
    private TextField isfcode;
    @FXML
    private TextField isfnationalite;
    @FXML
    private TextField isfphone;
    @FXML
    private TextField isfsexe;
    @FXML
    private TextField isfcompetences;
    @FXML
    private TextField isflanguage;
    @FXML
    private TextField isfentreprise;
    @FXML
    private TextField isfecole;
    @FXML
    private TextField isflinkdin;
    @FXML
    private TextField isfgithub;
    @FXML
    private TableView<Profil> isstable;
    @FXML
    private TableColumn<Profil, Integer> iss1;
    @FXML
    private TableColumn<Profil, String> iss2;
    @FXML
    private TableColumn<Profil, String> iss3;
    @FXML
    private TableColumn<Profil, String> iss4;
    @FXML
    private TableColumn<Profil, Integer> iss5;
    @FXML
    private TableColumn<Profil, String> iss6;
    @FXML
    private TableColumn<Profil, Integer> iss7;
    @FXML
    private TableColumn<Profil, String> iss8;
    @FXML
    private TableColumn<Profil, String> iss9;
    @FXML
    private TableColumn<Profil, String> iss10;
    @FXML
    private TableColumn<Profil, String> iss11;
    @FXML
    private TableColumn<Profil, String> iss12;
    @FXML
    private TableColumn<Profil, String> iss13;
    @FXML
    private TableColumn<Profil, String> iss14;
    @FXML
    private Button isfajou;
    @FXML
    private Button issmodifierprofil;
    @FXML
    private Button idssupprimer;
    @FXML
    private TextField is2;
    @FXML
    private TextField is3;
    @FXML
    private TableView<?> tab1;
    @FXML
    private TableColumn<?, ?> col1;
    @FXML
    private TableView<?> tab2;
    @FXML
    private TableColumn<?, ?> col2;
    @FXML
    private TextField is1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableProfil();
        // TODO
    }    

    @FXML
    private void ajoutProfil(ActionEvent event) {
        String nom = isfnom.getText();
        String prenom = isfprenom.getText();
        String addresse = isfaddresse.getText();
        int code = Integer.parseInt(isfcode.getText());
        String nationalite = isfnationalite.getText();
        int phone =Integer.parseInt( isfphone.getText());
        String sexe = isfsexe.getText();
        String competences = isfcompetences.getText();
        String language = isflanguage.getText();
        String entreprise = isfentreprise.getText();
        String ecole = isfecole.getText();
        String linkdin = isflinkdin.getText();
        String github = isfgithub.getText();
        
        ProfilCRUD pcd = new ProfilCRUD();
        Profil t =new Profil(nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd.ajouterProfil(t);
        isstable.getItems().clear();
        loadTableProfil();
    }
    ObservableList<Network> oblista = FXCollections.observableArrayList();
     NetworkCRUD pcd1= new NetworkCRUD();
    private void loadTablenet(){//affiche foramtion
        List <Network> fs =pcd1.afficherNetwork();
        fs.forEach(e->oblista.add(e));
        System.out.println(oblista);
        col1.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        col2.setCellValueFactory(new PropertyValueFactory<>("notification"));
        //is3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    }
    
    ObservableList<Profil> oblist = FXCollections.observableArrayList();
     ProfilCRUD pcd= new ProfilCRUD();
     
     
   
     private void loadTableProfil(){//affiche foramtion
        List <Profil> fs =pcd.afficherProfil();
        fs.forEach(e->oblist.add(e));
        System.out.println(oblist);
        iss1.setCellValueFactory(new PropertyValueFactory<>("id"));
        iss2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        iss3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        iss4.setCellValueFactory(new PropertyValueFactory<>("addresse"));
        iss5.setCellValueFactory(new PropertyValueFactory<>("code_postal"));
        iss6.setCellValueFactory(new PropertyValueFactory<>("nationalite"));
        iss7.setCellValueFactory(new PropertyValueFactory<>("phone"));
        iss8.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        iss9.setCellValueFactory(new PropertyValueFactory<>("competences"));
        iss10.setCellValueFactory(new PropertyValueFactory<>("language"));
        iss11.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        iss12.setCellValueFactory(new PropertyValueFactory<>("ecole"));
        iss13.setCellValueFactory(new PropertyValueFactory<>("linkdin"));
        iss14.setCellValueFactory(new PropertyValueFactory<>("github"));
     isstable.setItems(oblist);
    }

    @FXML
    private void prime_selected(MouseEvent event) {
        int index = isstable.getSelectionModel().getSelectedIndex();
        Profil h = isstable.getSelectionModel().getSelectedItem();
       // .setText(iss1.getCellData(index).toString());
        isfnom.setText(iss2.getCellData(index));
        isfprenom.setText(iss3.getCellData(index));
        isfaddresse.setText(iss4.getCellData(index));
        isfcode.setText(iss5.getCellData(index).toString());
        isfnationalite.setText(iss6.getCellData(index));
        isfphone.setText(iss7.getCellData(index).toString());
        isfsexe.setText(iss8.getCellData(index));
        isfcompetences.setText(iss9.getCellData(index));
        isflanguage.setText(iss10.getCellData(index));
        isfentreprise.setText(iss11.getCellData(index));
        isfecole.setText(iss12.getCellData(index));
        isflinkdin.setText(iss13.getCellData(index));
        isfgithub.setText(iss14.getCellData(index));
    }

    @FXML
    private void ModifierProfil(ActionEvent event) {
        int index = isstable.getSelectionModel().getSelectedIndex();
        int id = iss1.getCellData(index);
        String nom = isfnom.getText();
        String prenom = isfprenom.getText();
        String addresse = isfaddresse.getText();
        int code = Integer.parseInt(isfcode.getText());
        String nationalite = isfnationalite.getText();
        int phone =Integer.parseInt( isfphone.getText());
        String sexe = isfsexe.getText();
        String competences = isfcompetences.getText();
        String language = isflanguage.getText();
        String entreprise = isfentreprise.getText();
        String ecole = isfecole.getText();
        String linkdin = isflinkdin.getText();
        String github = isfgithub.getText();
        ProfilCRUD pcd = new ProfilCRUD();
        Profil p = new Profil(id, nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd.modifierProfil(p);
        isstable.getItems().clear();
        loadTableProfil();
        
    }

    @FXML
    private void SupprimerProfil(ActionEvent event) {
        int index = isstable.getSelectionModel().getSelectedIndex();
        int id = iss1.getCellData(index);
        ProfilCRUD pcd = new ProfilCRUD();
        Profil p = new Profil(id);
        pcd.supprimerProfil(p);
        isstable.getItems().clear();
        loadTableProfil();
        
    }

    @FXML
    private void envoprof(ActionEvent event) {
        String nom = is1.getText();
        String prenom = is2.getText();
        String addresse = is3.getText();
         NetworkCRUD pcd2 = new NetworkCRUD();
        Network t =new Network(nom, prenom, addresse);
        pcd2.ajouterNetwork(t);
        tab1.getItems().clear();
        tab2.getItems().clear();
        loadTablenet();
    }
    
}
