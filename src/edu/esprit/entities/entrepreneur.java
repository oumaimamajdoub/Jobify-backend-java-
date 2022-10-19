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
public class entrepreneur {
  private int id;
  private String nom;
  private String email;
  private String mdp;
  private String numTel;
  private String Adresse;

    public entrepreneur(int id, String nom, String email, String mdp, String numTel, String Adresse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.Adresse = Adresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
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

    public void setNom(String nom) {
        this.nom = nom;
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
        return "entrepreneur{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", numTel=" + numTel + ", Adresse=" + Adresse + '}';
    }
    
  
}
