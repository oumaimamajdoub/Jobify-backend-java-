/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_pi;

import entities.Evenement;
import entities.Participant;
import services.Service_evenement;
import services.Service_participants;
import utils.Myconnection;

/*
 tester le travail
 */
public class Projet_pi {
    public static void main(String[] args) {
        Myconnection mc =Myconnection.getInstance();
        //System.out.println("hello world ");
   // Service_evenement es = new Service_evenement();
     // Evenement es1= new Evenement("azerty"," HHH55555555H", "aze123", 1, "aze", "aze", "aze", 12345678);
    //    Evenement es2= new Evenement( "by"," 55", "66", 5, "aze", "wfxw", "wcx", 646);
    //   Evenement es3= new Evenement( "aaaaa"," 75", "66", 5, "aze", "wfxw", "wcx", 646);
    
    
     //es.ajouter(es1);
   // es.modifierev(es1);
    //System.out.println(es.afficher());
    //es.Supprimer(es1);
    
    Service_participants ps = new Service_participants();
    
       // Participant ps1= new Participant(1);
        //Participant ps2= new Participant(1,11111235);
        Participant ps1= new Participant(12,45,463);
        ps.ajouter(ps1);
        //Participant ps2= new Participant(2,4,4163);
        //Participant ps3= new Participant(1255,4,4563);
        //Participant ps4= new Participant(1,411,41633);
        //ps.ajouter(ps1);
        //ps.modifier(ps2);
    //System.out.println(ps.afficher());
   //ps.Supprimer(ps2);
        
        
        
        
        
        
    }

  
    
}
