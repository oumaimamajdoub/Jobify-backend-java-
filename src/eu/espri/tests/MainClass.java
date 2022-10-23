/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.espri.tests;

import edu.esprit.services.adminCRUD;
import edu.esprit.services.candidateCRUD;
import edu.esprit.services.entrepreneurCRUD;
import edu.esprit.services.userCRUD;
import edu.esprit.utils.MyConnection;
import edu.esprit.entities.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MainClass {
    public static void main(String[] args) {
       
       User u1 = new User(56,"mohggggame","hsan","@esprit","mdp","8577787","kdggggjd","uggggser");
       User u2 = new User(56,"hsane","hsmohan","wiwwt","mdwiiwp","7","kjd","lasmarRRRr");
       User u3 = new User(56,"hsane","hsmohan","wiwwt","mdwiiwp","7","kjd");
       ArrayList<User> myList = new ArrayList<User>();
       entrepreneurCRUD pcd= new entrepreneurCRUD();
       userCRUD pc = new userCRUD();
       adminCRUD ac = new adminCRUD();
       candidateCRUD cc = new candidateCRUD();
       //pc.ajouteruser(u1);
       //pc.supprimeruser(9);
       //pc.modifierUser(1,u2);
       //cc.ajoutercandidate(u3);
       //pcd.ajouterentrepreneur(u3);
    }
    
}
