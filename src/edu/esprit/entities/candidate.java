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
public class candidate {
  private int id,age;
  private String nom;
  private String prenom;
  private String email;
  private String mdp;
  private String numTel;
  private String Adresse;

    public candidate(int id, int age, String nom, String prenom, String email, String mdp, String numTel, String Adresse) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.Adresse = Adresse;
    }
  
  

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    @Override
    public String toString() {
        return "candidate{" + "id=" + id + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", numTel=" + numTel + ", Adresse=" + Adresse + '}';
    }
    
}
