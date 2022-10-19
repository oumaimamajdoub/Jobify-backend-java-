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
public class admin {
   
  private int id;
  private String email;
  private String mdp;

    public admin(int id, String email, String mdp) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
    }

   

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "admin{" + "id=" + id + ", email=" + email + ", mdp=" + mdp + '}';
    }
    

   
    
}

