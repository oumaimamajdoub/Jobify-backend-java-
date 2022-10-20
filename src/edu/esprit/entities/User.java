/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author LENOVO
 */
public class User {
  private int id,age;
  private String nom;
  private String prenom;
  private String email;
  private String mdp;
  private String numTel;
  private String Adresse;
  private String Role;

    public User(int age, String nom, String prenom, String email, String mdp, String numTel, String Adresse, String Role) {
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.Adresse = Adresse;
        this.Role = Role;
    }

    public User(int id, int age, String nom, String prenom, String email, String mdp, String numTel, String Adresse) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.Adresse = Adresse;
    }

    public User(int age, String nom, String prenom, String email, String mdp, String numTel, String Adresse) {
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.Adresse = Adresse;
    }

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getRole() {
        return Role;
    }

    public void setEtat(String Role) {
        this.Role = Role;
    }

    

 

    public User(int id, int age, String nom, String prenom, String email, String mdp, String numTel, String Adresse, String Role) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.Adresse = Adresse;
        this.Role = Role;
    }
}
