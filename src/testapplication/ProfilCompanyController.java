/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication;

//import com.teamdev.jxmaps.Map;
//import entities.Profil;
import entities.Network;
import entities.ProfilCompany;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import entities.ProfilUser;
import java.net.URL;
import java.util.List;
import java.util.Random;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import services.NetworkCRUD;
//import services.ProfilCRUD;
import services.ProfilcompanyCRUD;
//import services.ProfiluserCRUD;

/**
 * FXML Controller class
 *
 * @author Ismail
 */
public class ProfilCompanyController implements Initializable {

    @FXML
    private TextField isfnom;
    @FXML
    private Label isnom;
    @FXML
    private Label isaddresse;
    @FXML
    private Label iscode;
    @FXML
    private Label isphone;
    @FXML
    private Label isentreprise;
    @FXML
    private Label isecole;
    @FXML
    private Label islinkdin;
    @FXML
    private TextField isfaddresse;
    @FXML
    private TextField isfcode;
    private TextField isfnationalite;
    @FXML
    private TextField isfphone;
    @FXML
    private TextField isfentreprise;
    @FXML
    private TextField isfecole;
    @FXML
    private TextField isflinkdin;
    @FXML
    private Label issmodflabl;
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
    private TableView<ProfilCompany> tableuse;
    @FXML
    private TableColumn<ProfilCompany, Integer> iss1;
    @FXML
    private TableColumn<ProfilCompany, String> iss2;
    @FXML
    private TableColumn<ProfilCompany, String> iss4;
    @FXML
    private TableColumn<ProfilCompany,Integer> iss5;
    @FXML
    private TableColumn<ProfilCompany, Integer> iss7;
    @FXML
    private TableColumn<ProfilCompany, String> iss13;
    @FXML
    private ImageView img;
    @FXML
    private Button importimg;
    @FXML
    private TableColumn<ProfilCompany, Float> iss131;
    @FXML
    private TableColumn<ProfilCompany, Float> iss132;
    @FXML
    private Button mapshow;

    /**
     * Initializes the controller class.
     */
    double a =36.702269,b=10.244232;
    @FXML
    private TextField URL_ImageModif;
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
        // TODO
        loadTableProfil();
    }    
        ObservableList<ProfilCompany> oblist = FXCollections.observableArrayList();
     ProfilcompanyCRUD pcd= new ProfilcompanyCRUD();
    private void loadTableProfil(){//affiche foramtion
        List <ProfilCompany> fs =pcd.afficherProfilcr();
        fs.forEach(e->oblist.add(e));
        System.out.println(oblist);
        iss1.setCellValueFactory(new PropertyValueFactory<>("id"));
        iss2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        iss4.setCellValueFactory(new PropertyValueFactory<>("addresse"));
        iss5.setCellValueFactory(new PropertyValueFactory<>("code_postal"));
        iss7.setCellValueFactory(new PropertyValueFactory<>("phone"));
        iss132.setCellValueFactory(new PropertyValueFactory<>("maplarg"));
        iss13.setCellValueFactory(new PropertyValueFactory<>("linkdin"));
        iss131.setCellValueFactory(new PropertyValueFactory<>("maplong"));
        //iss15.setCellValueFactory(new PropertyValueFactory<>("imagesrc"));
     tableuse.setItems(oblist);
    }

    @FXML
    private void ModifierProfilcr(ActionEvent event) {
        int index = tableuse.getSelectionModel().getSelectedIndex();
        int id = iss1.getCellData(index);
        String nom = isfnom.getText();
        //String prenom = isfprenom.getText();
        String addresse = isfaddresse.getText();
        int code = Integer.parseInt(isfcode.getText());
        //String nationalite = isfnationalite.getText();
        int phone =Integer.parseInt( isfphone.getText());
       // String sexe = isfsexe.getText();
       // String competences = isfcompetences.getText();
       // String language = isflanguage.getText();
        float maplong = Float.parseFloat(isfentreprise.getText());
        float maplarg = Float.parseFloat(isfecole.getText());
        String linkdin = isflinkdin.getText();
        //String github = isfgithub.getText();
        ProfilcompanyCRUD pcd = new ProfilcompanyCRUD();
        ProfilCompany p = new ProfilCompany(id, nom,  addresse, code,  phone,  maplong, maplarg, linkdin );
        pcd.modifierProfilcr(p);
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
        ProfilcompanyCRUD pcd = new ProfilcompanyCRUD();
        ProfilCompany p = new ProfilCompany(id);
        pcd.supprimerProfilcr(p);
       /* ProfilCRUD pcd1 = new ProfilCRUD();
        Profil p1 = new Profil(id);
        pcd1.supprimerProfil(p1);
        */
        tableuse.getItems().clear();
        loadTableProfil();
    }

    @FXML
    private void ajoutprofcr(ActionEvent event) {
        String nom = isfnom.getText();
        String prenom = "----";
        String addresse = isfaddresse.getText();
        int code = Integer.parseInt(isfcode.getText());
        //String nationalite = isfnationalite.getText();
        int phone =Integer.parseInt( isfphone.getText());
        String sexe = "----";
        String competences = "----";
        String language = "----";
        //String entreprise = isfentreprise.getText();
        //String ecole = isfecole.getText();
        String linkdin = isflinkdin.getText();
        String github = "----";
        
        float maplong = Float.parseFloat(isfentreprise.getText());
        float maplarg = Float.parseFloat(isfecole.getText());
        String image = URL_ImageModif.getText();
        ProfilcompanyCRUD pcd = new ProfilcompanyCRUD();
        ProfilCompany t =new ProfilCompany( nom,  addresse, code,  phone,  maplong, maplarg, linkdin , image );
        pcd.ajouterProfilcr(t);
        /*ProfilCRUD pcd1 = new ProfilCRUD();
        Profil t1 =new Profil(nom, prenom, addresse, code, nationalite, phone, sexe, competences, language, entreprise, ecole, linkdin, github);
        pcd1.ajouterProfil(t1);*/
        tableuse.getItems().clear();
        loadTableProfil();
    }

    @FXML
    private void prime2_select(MouseEvent event) {
        //ProfilCompany usr = tableuse.getSelectionModel().getSelectedItem();
        int index = tableuse.getSelectionModel().getSelectedIndex();
        ProfilCompany h = tableuse.getSelectionModel().getSelectedItem();
       issIDmodf.setText(iss1.getCellData(index).toString());
        isfnom.setText(iss2.getCellData(index));
        //isfprenom.setText(iss3.getCellData(index));
        isfaddresse.setText(iss4.getCellData(index));
        isfcode.setText(iss5.getCellData(index).toString());
        //isfnationalite.setText(iss6.getCellData(index));
        isfphone.setText(iss7.getCellData(index).toString());
        //isfsexe.setText(iss8.getCellData(index));
        //isfcompetences.setText(iss9.getCellData(index));
        //isflanguage.setText(iss10.getCellData(index));
        isfentreprise.setText(iss131.getCellData(index).toString());
        isfecole.setText(iss132.getCellData(index).toString());
        isflinkdin.setText(iss13.getCellData(index));
        //isfgithub.setText(iss14.getCellData(index));
        a=iss131.getCellData(index);
        b=iss132.getCellData(index);
        try{
        String path = h.getImage();
            System.out.println(path);
            System.out.println("yrecuperi b shyyh !");
            File file = new File(path);
            URL_ImageModif.setText(path);
            Image imga = new Image(file.toURI().toString());
            img.setImage(imga);
            } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        
    }

    @FXML
    private void importerimage(ActionEvent event)throws FileNotFoundException, IOException {
        Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
       String DBPath = "C:\\Users\\Ismail\\Desktop\\d" + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path = file.getAbsolutePath();
            Image imga = new Image(file.toURI().toString());
            img.setImage(imga);
            URL_ImageModif.setText(DBPath);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();

        } else {
            System.out.println("error");

        }
    }

    @FXML
    private void showmaps(ActionEvent event) {
        Mapa temp = new Mapa("maps",a,b);
        
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
    private void envoprofcomp(ActionEvent event) {
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
