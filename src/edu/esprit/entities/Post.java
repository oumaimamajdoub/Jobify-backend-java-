/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author afefz
 */
public class Post {
  private int id;
  private String titre;
  private String description;
 private Date DateDeCreation;
  private Date DateExpiration;
  private int salaire;
  
public Post(){
}
    public Post(int id, String titre, String description, Date DateDeCreation, Date DateExpiration, int salaire) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.DateDeCreation = DateDeCreation;
        this.DateExpiration = DateExpiration;
        this.salaire = salaire;
    }
     public Post( String titre, String description,Date DateDeCreation, Date DateExpiration, int salaire) {
      
        this.titre = titre;
        this.description = description;
        this.DateDeCreation = DateDeCreation;
        this.DateExpiration = DateExpiration;
        this.salaire = salaire;
    }

    public Post(int id) {
        this.id = id;
    }

 
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDeCreation() {
        return DateDeCreation;
    }

    public void setDateDeCreation(Date DateDeCreation) {
        this.DateDeCreation = DateDeCreation;
    }

    public Date getDateExpiration() {
        return DateExpiration;
    }

    public void setDateExpiration(Date DateExpiration) {
        this.DateExpiration = DateExpiration;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", DateDeCreation=" + DateDeCreation + ", DateExpiration=" + DateExpiration +", salaire=" + salaire + '}'+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.salaire != other.salaire) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.DateDeCreation, other.DateDeCreation)) {
            return false;
        }
        if (!Objects.equals(this.DateExpiration, other.DateExpiration)) {
            return false;
        }
        return true;
    }

    

   

  
}
