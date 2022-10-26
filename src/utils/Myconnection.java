/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;

/**
 *
 * @author LENOVO
 */
public class Myconnection {
    private String url = "jdbc:mysql://localhost:3306/recherche_demploi";
    private String username = "root";
    private String password = "";
    
    private Connection cnx;
    private static Myconnection instance;
    
    public Myconnection() {
        try {
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("database connected");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    public static Myconnection getInstance() {
        if(instance == null){
            instance = new Myconnection();
        }
        return instance;
    }
    
}


