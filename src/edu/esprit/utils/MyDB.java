/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class MyDB {
    
    String url="jdbc:mysql://localhost/4se4";
    String user="root";
    String password="";
    Connection cnx;
    static MyDB instance;
    
public MyDB ()  {
        try {
            cnx= DriverManager.getConnection(url, user, password);
          System.out.println("Connexion établie");  
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}

public MyDB getInstance() {
    if (instance ==null){
        instance =new MyDB();
}
return instance;
}

   
}
