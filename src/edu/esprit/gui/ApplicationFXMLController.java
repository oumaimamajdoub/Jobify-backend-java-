/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Application;
import edu.esprit.entities.Post;
import edu.esprit.services.ApplicationCRUD;
import edu.esprit.services.PostCRUD;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author afefz
 */
public class ApplicationFXMLController implements Initializable {

    @FXML
    private TableView<Post> tablepost;
    @FXML
    private TableColumn<Post, String> tctitre;
    @FXML
    private TableColumn<Post, String> tcdescription;
    @FXML
    private TableColumn<Post, Date> tcdatecreation;
    @FXML
    private TableColumn<Post, Date> tcdateexpiration;
    @FXML
    private TableColumn<Post, Integer> tcsalaire;
    ObservableList<Post> data=FXCollections.observableArrayList();
    PostCRUD pc=new PostCRUD();
    ApplicationCRUD ac=new ApplicationCRUD();
    @FXML
    private Button btnapplication;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    private void application(ActionEvent event) {
        Post selectedPost=tablepost.getSelectionModel().getSelectedItem();
        if(selectedPost!=null){
            Application a=new Application();
            a.setDateApplication(Date.valueOf(LocalDate.now()));
            a.setIdPost(selectedPost.getId());
            a.setIdCandidat(22);
            ac.ajouter(a);
            TrayNotification tray=new TrayNotification();
            AnimationType type=AnimationType.POPUP;
            tray.setTitle("Application");
            tray.setMessage("Vous avez bien appliquer a une poste");
            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setAnimationType(type);
            tray.showAndDismiss(Duration.seconds(2));
            btnapplication.setDisable(true);
            
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
