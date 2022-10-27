/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Profil;
import outils.MyDB;
import services.ProfilCRUD;

/**
 *
 * @author Ismail
 */
public class Test {
    public static void main(String[] args) {
        MyDB.getInstance();
        ProfilCRUD pcd = new ProfilCRUD();
        Profil p = new Profil("ismail","khlif","sfax",3030,"tunisia",2656,"man","java","arabic","esprit","esprit","linkdi","githb");
        Profil p3 = new Profil("mohsen","kf","tunos",7730,"tunisia",8794,"man","javac","english","actia","esprit","linkdin","github");
        Profil p5 = new Profil("sefg","kf","sdfg",77230,"tunisia",87294,"man","javac","english","actia","esprit","linkdin","github");
        Profil p2 = new Profil(1,"monji","bazd");
        Profil p4 = new Profil(1);
        
       //pcd.ajouterProfil(p5);
        //pcd.modifierProfil(p2);
        pcd.supprimerProfil(p4);
        pcd.afficherProfil().forEach(System.out::println);
    }
    
}
