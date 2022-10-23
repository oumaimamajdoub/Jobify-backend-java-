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
public class Document {

  private int id;
  private String nom;
  private String path;
  private Date DateDeCreation;
  private int idContrat;
  private int idCandidat;

    public Document(int id, String nom, String path, Date DateDeCreation, int idContrat, int idCandidat) {
        this.id = id;
        this.nom = nom;
        this.path = path;
        this.DateDeCreation = DateDeCreation;
        this.idContrat = idContrat;
        this.idCandidat = idCandidat;
    }

    public Document(String nom, String path, Date DateDeCreation, int idContrat, int idCandidat) {
        this.nom = nom;
        this.path = path;
        this.DateDeCreation = DateDeCreation;
        this.idContrat = idContrat;
        this.idCandidat = idCandidat;
    }

    public Document() {
    }

    public Document(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDateDeCreation() {
        return DateDeCreation;
    }

    public void setDateDeCreation(Date DateDeCreation) {
        this.DateDeCreation = DateDeCreation;
    }

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", nom=" + nom + ", path=" + path + ", DateDeCreation=" + DateDeCreation + ", idContrat=" + idContrat + ", idCandidat=" + idCandidat + '}'+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Document other = (Document) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idContrat != other.idContrat) {
            return false;
        }
        if (this.idCandidat != other.idCandidat) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.DateDeCreation, other.DateDeCreation)) {
            return false;
        }
        return true;
    }

    
   
   
  
    
}
