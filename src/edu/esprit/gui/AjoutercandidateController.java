/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.candidate;
import edu.esprit.services.candidateCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutercandidateController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfage;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmdp;
    @FXML
    private TextField tfnumTel;
    @FXML
    private TextField tfAdresse;
    @FXML
    private AnchorPane tfValider;
    @FXML
    private Button tfbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addcandidate(ActionEvent event) {
        int age = Integer.parseInt(tfage.getText());
        String nom = tfnom.getText();
        String prenom = tfprenom.getText();
        String email = tfemail.getText();
        String mdp = tfmdp.getText();
        String numTel = tfnumTel.getText();
        String Adresse = tfAdresse.getText();

        candidate c = new candidate(age, nom, prenom, email, mdp, numTel, Adresse);
        candidateCRUD cc = new candidateCRUD();
        cc.ajoutercandidate(c);

        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("Affichercandidate.fxml"));
        try {
            Parent root = loader.load();

            AffichercandidateController acc = loader.getController();
            acc.setTfnom(c.getNom());
            acc.setTfprenom(c.getPrenom());
            acc.setTfemail(c.getEmail());
            acc.setTfage("" + c.getAge());
            acc.setTfmdp(c.getMdp());
            acc.setTfnumTel(c.getNumTel());
            acc.setTfAdresse(c.getAdresse());

            tfnom.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.print(ex.getMessage());

        }
    }
}
