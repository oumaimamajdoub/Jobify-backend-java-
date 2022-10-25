/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.services.PostCRUD;
import edu.esprit.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

/**
 * FXML Controller class
 *
 * @author afefz
 */
public class Stat_application_postFXMLController implements Initializable {

    @FXML
    private PieChart piechart;
    ObservableList<Data> data=FXCollections.observableArrayList();
    PostCRUD pc=new PostCRUD();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        statpost();
    }
    public void statpost(){
        try {
            Connection cnx =MyConnection.getInstance().getCnx();
            String query="select count(*) as nbapplication,idPost as post from application group by idPost";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                data.add(new PieChart.Data(pc.getTitrePostById(rs.getInt("post")),rs.getInt("nbapplication")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stat_application_postFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        piechart.setTitle("*Statistique des applications selon poste");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);
    }
    
}
