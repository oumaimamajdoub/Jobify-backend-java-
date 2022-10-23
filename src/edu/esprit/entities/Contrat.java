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
public class Contrat {
     private int id;
     private String type;
     private Date DateDebut;
     private Date DateFin;
     private int salaire;

    public Contrat() {
    }

    public Contrat(int id) {
        this.id = id;
    }
    

    public Contrat(int id, String type, Date DateDebut, Date DateFin, int salaire) {
        this.id = id;
        this.type = type;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.salaire = salaire;
    }

    public Contrat(String type, Date DateDebut, Date DateFin, int salaire) {
        this.type = type;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id=" + id + ", type=" + type + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", salaire=" + salaire + '}'+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Contrat other = (Contrat) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.salaire != other.salaire) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.DateDebut, other.DateDebut)) {
            return false;
        }
        if (!Objects.equals(this.DateFin, other.DateFin)) {
            return false;
        }
        return true;
    }

   
    
}
