/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class MyConnection {
    public String url="jdbc:mysql://localhost:3306/testdb";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public MyConnection() {
        try {
          cnx=(Connection) DriverManager.getConnection(url, login, pwd);
          System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());       }
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public Connection getCnx() {
        return cnx;
    }

    
    

    public static class getInstance extends MyConnection {

        public getInstance() {
        }
    }

    
}
