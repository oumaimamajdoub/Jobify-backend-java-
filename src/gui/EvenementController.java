/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
//hello im here
import com.itextpdf.text.BadElementException;
import static com.itextpdf.text.BaseColor.BLUE;
import static com.itextpdf.text.BaseColor.YELLOW;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Evenement;
import entities.Participant;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.Service_evenement;
import services.Service_participants;
import utils.Myconnection;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EvenementController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tforganisateur;
    @FXML
    private TextField tflieu;
    @FXML
    private TextField tfdisponibilite;
    @FXML
    private TextField tfprogramme;
    @FXML
    private TextField tfnumcontact;
    @FXML
    private TextField tfdd;
    @FXML
    private TextField tfdf;
    @FXML
    private Button ajout_souha;
    @FXML
    private Button modifier_souha;
    @FXML
    private Button supprimer_souha;
    @FXML
    private TableView<Evenement> tfevenement;
    @FXML
    private TableColumn<Evenement, String> colnom;
    @FXML
    private TableColumn<Evenement, Integer> colorganisateur;
    @FXML
    private TableColumn<Evenement, String> collieu;
    @FXML
    private TableColumn<Evenement, String> coldisponibilite;
    @FXML
    private TableColumn<Evenement, String> colprogramme;
    @FXML
    private TableColumn<Evenement, Integer> colnumcontact;
    @FXML
    private TableColumn<Evenement, String> coldd;
    @FXML
    private TableColumn<Evenement, String> coldf;
    @FXML
    private Label evenement;
    static Evenement selectedItemm;
    @FXML
    private Label tfid;
    @FXML
    private TextField affTotal;
    @FXML
    private TextField a_pic;
   @FXML
    private TextField numPlaceText;
    @FXML
    private TableColumn<Evenement,Integer> numPla;
    @FXML
    private Button pdfButton;
    @FXML
    private Button B_import;
    @FXML
    private ImageView a_picture_kol;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Myconnection conn = new Myconnection();
        Connection cnx = conn.getCnx();
        loadTablevent();
        // TODO
    }
    
    ObservableList<Evenement> oblist = FXCollections.observableArrayList();
    Service_evenement es = new Service_evenement();

    ObservableList<Participant> oblistP = FXCollections.observableArrayList();
    Service_participants ps = new Service_participants();

    private void loadTablevent() {//affiche EVENT
        ObservableList<Evenement> ls = es.afficher();
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom_ev"));
        colprogramme.setCellValueFactory(new PropertyValueFactory<>("programme_ev"));
        colorganisateur.setCellValueFactory(new PropertyValueFactory<>("organisateur_ev"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu_ev"));
        coldisponibilite.setCellValueFactory(new PropertyValueFactory<>("disponibilite_ev"));
        coldd.setCellValueFactory(new PropertyValueFactory<>("date_debut_ev"));
        coldf.setCellValueFactory(new PropertyValueFactory<>("date_fin_ev"));
        colnumcontact.setCellValueFactory(new PropertyValueFactory<>("num_contact"));
         numPla.setCellValueFactory(new PropertyValueFactory<>("parNumb"));
         //numPla.setCellFactory(new PropertyValueFactory<>("parnumb"));
        
        tfevenement.setItems(ls);
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException, IOException, ParseException {
        if (tfnom.getText().equals("") || tflieu.getText().equals("") || tfdisponibilite.getText().equals("")
                || tfnumcontact.getText().equals("") || tforganisateur.getText().equals("") || tfprogramme.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir tout les champs ");//controle de saisie
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date datestart1 = format.parse(tfdd.getText());
            java.util.Date dateend1 = format.parse(tfdf.getText());
            java.sql.Date datestart = new java.sql.Date(datestart1.getTime());
            java.sql.Date dateend = new java.sql.Date(dateend1.getTime());

            int organisateur_ev = Integer.valueOf(tforganisateur.getText());
            String lieu_ev = tflieu.getText();
            String disponibilite_ev = tfdisponibilite.getText();
            String programme_ev = tfprogramme.getText();
            int num_contact = Integer.valueOf(tfnumcontact.getText());
            String date_debut_ev = tfdd.getText();
            String date_fin_ev = tfdf.getText();
            Evenement e = new Evenement();
            e.setNom_ev(tfnom.getText());
            e.setOrganisateur_ev(organisateur_ev);
            e.setLieu_ev(tflieu.getText());
            e.setDisponibilite_ev(tfdisponibilite.getText());
            e.setProgramme_ev(tfprogramme.getText());
            e.setNum_contact(num_contact);
            e.setDate_debut_ev(datestart.toString());
            e.setUserID(1);// user.getID()baed l integration 
            e.setDate_fin_ev(dateend.toString());
            e.setParNumb(Integer.valueOf(numPlaceText.getText()));
            Service_evenement sv = new Service_evenement();
            sv.ajouter(e);
            loadTablevent();
        }

    }

    @FXML
    private void modifier(ActionEvent event) throws ParseException {

        if (tfnom.getText().equals("") || tflieu.getText().equals("") || tfdisponibilite.getText().equals("")
                || tfnumcontact.getText().equals("") || tforganisateur.getText().equals("") || tfprogramme.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir tout les champs ");//controle de saisie
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date datestart1 = format.parse(tfdd.getText());
            java.util.Date dateend1 = format.parse(tfdf.getText());
            java.sql.Date datestart = new java.sql.Date(datestart1.getTime());
            java.sql.Date dateend = new java.sql.Date(dateend1.getTime());

            int organisateur_ev = Integer.valueOf(tforganisateur.getText());
            String lieu_ev = tflieu.getText();
            String disponibilite_ev = tfdisponibilite.getText();
            String programme_ev = tfprogramme.getText();
            int num_contact = Integer.valueOf(tfnumcontact.getText());
            String date_debut_ev = tfdd.getText();
            String date_fin_ev = tfdf.getText();
            Evenement e = new Evenement();
            e.setNom_ev(tfnom.getText());
            e.setOrganisateur_ev(organisateur_ev);
            e.setLieu_ev(tflieu.getText());
            e.setDisponibilite_ev(tfdisponibilite.getText());
            e.setProgramme_ev(tfprogramme.getText());
            e.setNum_contact(num_contact);
            e.setDate_debut_ev(datestart.toString());
            e.setDate_fin_ev(dateend.toString());
            e.setId_ev(selectedItemm.getId_ev());
            e.setParNumb(Integer.valueOf(numPlaceText.getText()));
            Service_evenement sv = new Service_evenement();
            sv.modifierev(e);
            loadTablevent();
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        Evenement e = tfevenement.getSelectionModel().getSelectedItem();
        es.Supprimer(e);
        
        loadTablevent();
    }

    @FXML
    private void index3(javafx.scene.input.MouseEvent event) {
        selectedItemm = tfevenement.getSelectionModel().getSelectedItem();
        tfid.setText(String.valueOf(selectedItemm.getId_ev()));
        tfnom.setText(String.valueOf(selectedItemm.getNom_ev()));
        tforganisateur.setText(String.valueOf(selectedItemm.getOrganisateur_ev()));
        tflieu.setText(String.valueOf(selectedItemm.getLieu_ev()));
        tfdisponibilite.setText(String.valueOf(selectedItemm.getDisponibilite_ev()));
        tfprogramme.setText(String.valueOf(selectedItemm.getProgramme_ev()));
        tfnumcontact.setText(String.valueOf(selectedItemm.getNum_contact()));
        tfdd.setText(String.valueOf(selectedItemm.getDate_debut_ev()));
        tfdf.setText(String.valueOf(selectedItemm.getDate_fin_ev()));
        numPlaceText.setText(String.valueOf(selectedItemm.getParNumb()));
    }

    @FXML
    private void parti(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Participent.fxml"));
        Scene scene3 = new Scene(fxml);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }

    @FXML
    private void total(ActionEvent event) {
        Service_evenement se = new Service_evenement();
        long  x= 1; // user.getID()baed l integration
        affTotal.setText(String.valueOf(se.getTotal(x)));
    }

    @FXML
    private void h_importpath(ActionEvent event) {
  String url=a_pic.getText();
        System.out.println(url);

            Image image = new Image(url);
            if (image.isError()) {
                System.out.println("Error loading image from "+url);
                
                // image.getException().printStackTrace();
            } else {
                System.out.println("Successfully loaded image from " + url);
                a_picture_kol.setImage(image);
            }
               
    }
    @FXML
    private void ExporterPdf(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
        
        Document doc =new Document();
        try {
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\LENOVO\\Desktop\\pdf\\evenementPdf"));
        doc.open();
                 doc.add(new Paragraph (new Phrase("Evenement ",FontFactory.getFont("Arial",30,YELLOW))));

         //doc.add(new Paragraph ("Evenement",FontFactory.getFont("Arial",16)));
        doc.add(new Paragraph("***********************************************************"));
        doc.add(new Paragraph ("Nom",FontFactory.getFont("Arial", 12)));
        doc.add(new Paragraph (tfnom.getText(),FontFactory.getFont("Arial", 12)));
        doc.add(new Paragraph (new Phrase("tforganisateur :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tforganisateur.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("lieu :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tflieu.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("disponibilite:",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfdisponibilite.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("programme :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfprogramme.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("numcontact :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfnumcontact.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Date_debut:",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfdd.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("Date_fin :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfdf.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph(new Phrase(pdfButton.getText(),FontFactory.getFont("Arial",10))));
                   doc.add(new Paragraph (new Phrase("Numbre de Place:",FontFactory.getFont("Arial",12))));


         doc.add(new Paragraph("*****************************************************"));
         doc.add(new Paragraph (new Phrase("A bientot! ",FontFactory.getFont("Arial",10,YELLOW))));
         doc.close();
        Desktop.getDesktop().open(new File ("C:\\Users\\LENOVO\\Desktop\\pdf\\evenementPdf"));
        
        
        
        
    }catch(FileNotFoundException e){e.printStackTrace();} catch (IOException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void getevent(ActionEvent event)   throws FileNotFoundException, DocumentException, BadElementException, IOException {
        
         Document doc =new Document();
        try{
                        System.out.println("doc opned");
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\pdfJava"));
        doc.open();
        com.itextpdf.text.Image img=com.itextpdf.text.Image.getInstance("C:\\Users\\USER\\Desktop\\gl\\Capturefin.PNG");
       
        img.scaleAbsoluteWidth(80);
        img.scaleAbsoluteHeight(60);
        
         doc.add(img);
        doc.add(new Paragraph ("Evenement",FontFactory.getFont("Arial",16)));
        doc.add(new Paragraph("------------"));
         doc.add(new Paragraph (new Phrase(" Id:",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfid.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Nom :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfnom.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("tforganisateur :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tforganisateur.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("lieu :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tflieu.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("disponibilite:",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfdisponibilite.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("programme :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfprogramme.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("numcontact :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfnumcontact.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Date_debut:",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfdd.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("Date_fin :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(tfdf.getText(),FontFactory.getFont("Arial",10))));
         
           doc.add(new Paragraph("------------"));
         doc.add(new Paragraph (new Phrase("Evenement ",FontFactory.getFont("Arial",9,YELLOW))));
          
         
        doc.close();
        Desktop.getDesktop().open(("C:\\pdfJava"));
        
    }catch(FileNotFoundException e){e.printStackTrace();} catch (IOException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }

    @FXML
    private void Import(javafx.scene.input.MouseEvent event) {
    }
   












}

////CONROLE DE SAISIE//////////////////////
/*if (txt_dispo.getText().equals("") || txt_lieu.getText().equals("") || txt_nom_event.getText().equals("") || txt_num.getText().equals("") || txt_organisateur.getText().equals("") || txt_programe_event.getText().equals("")) {
           JOptionPane.showMessageDialog(null, "veuillez remplir tout les champs ");//controle de saisie
           } else {
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date datestart = Date.valueOf(date_db.getValue());
          java.sql.Date dateend = Date.valueOf(dateend.getValue());

            //if (datestart.compareTo(dateend) > 0) {
              //  JOptionPane.showMessageDialog(null, "veuiller remplir avec parametre reel");
            //}
            //else
           {
               int nbr1 = Integer.parseInt(txt_organisateur.getText());
               int nbr2 = Integer.parseInt(txt_num.getText());

   //String url = "https://media.istockphoto.com/photos/downtown-cleveland-hotel-entrance-and
        //-waiting-taxi-cab-picture-id472899538?b=1&k=20&m=472899538&s=170667a&w=0&h=oGDM26vWKgcKA3ARp2da-H4St2dMEhJg23TTBeJgPDE=";
        String url=a_pic.getText();
        System.out.println(url);

            Image image = new Image(url);
            if (image.isError()) {
                System.out.println("Error loading image from "+url);
                
                // image.getException().printStackTrace();
            } else {
                System.out.println("Successfully loaded image from " + url);
                a_picture_kol.setImage(image);
            }
        
//      JFileChooser chooser = new JFileChooser();
//      chooser.showOpenDialog(null);
//      File f  =chooser.getSelectedFile();
//      String filename =f.getAbsolutePath();
//      a_pic.setText(filename);
//      Image getAbolutePath =null;
//      ImageIcon icon = new ImageIcon(filename);
      //Image image = icon.getImage().getScaledInstance(a_picture_kol.getWidth(),a_picture_kol.getHeight(),Image.);
 */
