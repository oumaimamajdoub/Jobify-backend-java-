/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Ismail
 */
public class MyDB {
    String url = "jdbc:mysql://localhost:3306/revolution" ;
    String user = "root" ;
    String password = "";
    Connection cnx;
    static MyDB instance;
    private MyDB() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connection etabli");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public Connection getCnx(){
        return cnx;
    }
    public static MyDB getInstance(){
        if (instance == null)
        { instance = new MyDB();}
        return instance ;
    }
    
}
