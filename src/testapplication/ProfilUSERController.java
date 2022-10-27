/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication;


import entities.Network;
import entities.Profil;
import entities.ProfilUser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.channels.AsynchronousFileChannel;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import outils.MyDB;
import services.NetworkCRUD;
import services.ProfilCRUD;
import services.ProfiluserCRUD;
import sun.security.krb5.internal.ccache.FileCCacheConstants;

/**
 * FXML Controller class
 *
 * @author Ismail
 */
public class ProfilUSERController implements Initializable {

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
    private Label issmodflabl;
    @FXML
    private TextField isfnom;
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
    private TextField issIDmodf;
    @FXML
    private Button issmodifierprofil;
    @FXML
    private Button issretourmodf;
    @FXML
    private Button issmodifierprofil1;
    @FXML
    private Button issmodifierprofil2;
    @FXML
    private TableColumn<ProfilUser, Integer> iss1;
    @FXML
    private TableColumn<ProfilUser, String> iss2;
    @FXML
    private TableColumn<ProfilUser, String> iss3;
    @FXML
    private TableColumn<ProfilUser, String> iss4;
    @FXML
    private TableColumn<ProfilUser, Integer> iss5;
    @FXML
    private TableColumn<ProfilUser, String> iss6;
    @FXML
    private TableColumn<ProfilUser, Integer> iss7;
    @FXML
    private TableColumn<ProfilUser, String> iss8;
    @FXML
    private TableColumn<ProfilUser, String> iss9;
    @FXML
    private TableColumn<ProfilUser, String> iss10;
    @FXML
    private TableColumn<ProfilUser, String> iss11;
    @FXML
    private TableColumn<ProfilUser, String> iss12;
    @FXML
    private TableColumn<ProfilUser, String> iss13;
    @FXML
    private TableColumn<ProfilUser, String> iss14;
    @FXML
    private TabPane userwindw;
    @FXML
    private TableView<ProfilUser> tableuse;
    @FXML
    private ImageView img;
    @FXML
    private Button importimg;
    @FXML
    private TableColumn<ProfilUser, Blob> iss15;

    /**
     * Initializes the controller class.
     */
    private PreparedStatement store, retrive;
private String storestat = "INSERT INTO profiluser(imagesrc) values(?) ";
private String retrivestat = "SELECT imagesrc FROM profiluser WHERE id = ?";
    @FXML
    private TableView<?> amistabl;
    @FXML
    private TextField is2;
    @FXML
    private TableColumn<?, ?> col1;
    @FXML
    private TextField is3;
    @FXML
    private TableView<?> tab2;
    @FXML
    private TableColumn<?, ?> col2;
    @FXML
    private TextField is1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableProfil();
        // TODO
    }    

    public void save(){/*
        try {
            store = MyDB.getInstance().getCnx().prepareStatement(storestat);
            retrive = MyDB.getInstance().getCnx().prepareStatement(retrivestat);
                         } catch (SQLException ex) {
            System.out.println(ex);        }*/
    }
    private void ModifierProfiluser(ActionEvent event) {
        int index = tableuse.getSelectionModel().getSelectedIndex();
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
        ProfiluserCRUD pcd = new ProfiluserCRUD();
        ProfilUser p = new ProfilUser(id, nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd.modifierProfiluser(p);
       /* ProfilCRUD pcd1 = new ProfilCRUD();
        Profil p1 = new Profil(id, nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd1.modifierProfil(p1);*/
        tableuse.getItems().clear();
        loadTableProfil();
    }

    @FXML
    private void RetourModifier(ActionEvent event) {
    }

    @FXML
    private void suppprofiluser(ActionEvent event) {
        int index = tableuse.getSelectionModel().getSelectedIndex();
        int id = iss1.getCellData(index);
        ProfiluserCRUD pcd = new ProfiluserCRUD();
        ProfilUser p = new ProfilUser(id);
        pcd.supprimerProfiluser(p);
       /* ProfilCRUD pcd1 = new ProfilCRUD();
        Profil p1 = new Profil(id);
        pcd1.supprimerProfil(p1);
        */
        tableuse.getItems().clear();
        loadTableProfil();
    }

    @FXML
    private void ajoutprofuse(ActionEvent event) {
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
        
        ProfiluserCRUD pcd = new ProfiluserCRUD();
        ProfilUser t =new ProfilUser(nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd.ajouterProfiluser(t);
        ProfilCRUD pcd1 = new ProfilCRUD();
        Profil t1 =new Profil(nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd1.ajouterProfil(t1);
        tableuse.getItems().clear();
        loadTableProfil();
    }

    @FXML
    private void prime2_select(MouseEvent event) {
        int index = tableuse.getSelectionModel().getSelectedIndex();
        ProfilUser h = tableuse.getSelectionModel().getSelectedItem();
       issIDmodf.setText(iss1.getCellData(index).toString());
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
        /*
        try{
            retrive.setInt(1, 1);
            ResultSet resullSet = retrive.executeQuery();
            if(resullSet.first()){
                Blob blob = resullSet.getBlob(1);
                InputStream inputStream = blob.getBinaryStream();
                Image image = new Image(inputStream);
                img.setImage(image);
            }
            
        }catch(SQLException e ){
            System.out.println(e);
        }*/
    }
    ObservableList<ProfilUser> oblist = FXCollections.observableArrayList();
     ProfiluserCRUD pcd= new ProfiluserCRUD();
     
   
     private void loadTableProfil(){//affiche foramtion
        List <ProfilUser> fs =pcd.afficherProfiluser();
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
        //iss15.setCellValueFactory(new PropertyValueFactory<>("imagesrc"));
     tableuse.setItems(oblist);
    }
     
    @FXML
    private void importerimage(ActionEvent event) throws IOException {
        FileChooser Chosser = new FileChooser();
        
        FileChooser.ExtensionFilter exxtFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxtFilterPNG =new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        
        Chosser.getExtensionFilters().addAll(exxtFilterJPG,exxtFilterPNG);
        
        File file = Chosser.showOpenDialog(null);
        BufferedImage bufferedimg = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedimg, null);
        img.setImage(image);
       /*
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(importimg.getScene().getWindow());
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            store.setBinaryStream(1, fileInputStream,fileInputStream.available());
            store.execute();
            Image image = new Image(fileInputStream);
            img.setImage(image);
            
            
        
        }catch (IOException | SQLException e ){
            System.out.println(e);
        }*/
        
    }

    @FXML
    private void ModifierProfil(ActionEvent event) {
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


    @FXML
    private void envoprofuser(ActionEvent event) {
        String nom = is1.getText();
        String prenom = is2.getText();
        String addresse = is3.getText();
         NetworkCRUD pcd2 = new NetworkCRUD();
        Network t =new Network(nom, prenom, addresse);
        pcd2.ajouterNetwork(t);
        amistabl.getItems().clear();
        tab2.getItems().clear();
        loadTablenet();
    }
    
}
