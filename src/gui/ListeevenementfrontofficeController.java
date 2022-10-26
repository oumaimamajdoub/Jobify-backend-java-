/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import entities.Evenement;
import entities.Participant;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.Service_evenement;
import services.Service_participants;
import utils.Myconnection;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ListeevenementfrontofficeController implements Initializable {
  
    private Label label;
    private Pane teset;
    private VBox vbox;
    private HBox hbox;
    @FXML
    private TableColumn<Evenement, String> colnom;
    @FXML
    private TableColumn<Evenement, Integer> colnbr;
    @FXML
    private TableColumn<Evenement, String> coldd;
    @FXML
    private TableColumn<Evenement, String> coldf;
    @FXML
    private Button parti;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private ImageView qrcode;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          Myconnection conn = new Myconnection();
        Connection cnx = conn.getCnx();
      loadEvent();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "https://www.linkedin.com/learning/";
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {

        }
    qrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
    } 
        ObservableList<Evenement> oblist = FXCollections.observableArrayList();
        Service_evenement es = new Service_evenement();
        Service_participants ps= new Service_participants();
    public void loadEvent(){
   //
    ObservableList<Evenement> ls = es.afficher();
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom_ev"));    
        coldd.setCellValueFactory(new PropertyValueFactory<>("date_debut_ev"));
        coldf.setCellValueFactory(new PropertyValueFactory<>("date_fin_ev"));
         colnbr.setCellValueFactory(new PropertyValueFactory<>("parNumb"));
     //   colnbr.setCellFactory(new PropertyValueFactory<>("parnumb"));
        
        table.setItems(ls);
       
         }

    @FXML
    private void participe(ActionEvent event) {
      
         Evenement e = table.getSelectionModel().getSelectedItem();
         if(e.getParNumb()==0){
             ///notification
               Alert a1=new Alert(Alert.AlertType.WARNING);
          a1.setTitle("HI");
             a1.setContentText("Les places sont reserve monsieur\n Desoler!!! ");
        
             a1.setHeaderText(null);
             a1.showAndWait();   
         }else {
              int a=e.getParNumb()-1;
              System.out.println(a);
             e.setParNumb(a);
        es.modifierev(e);
         Participant pt = new Participant();
         pt.setId_ev(e.getId_ev());
        // pt.setId_user();//user connected 
      ps.ajouter(pt);
         }
         
    
    
    }
}
   
    
    

