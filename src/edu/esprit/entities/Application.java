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
public class Application {
    private int id;
    private int idPost;
    private int idCandidat;
    private Date dateApplication;

    public Application(int id, int idPost, int idCandidat, Date dateApplication) {
        this.id = id;
        this.idPost = idPost;
        this.idCandidat = idCandidat;
        this.dateApplication = dateApplication;
    }

    public Application(int idPost, int idCandidat, Date dateApplication) {
        this.idPost = idPost;
        this.idCandidat = idCandidat;
        this.dateApplication = dateApplication;
    }

    public Application() {
    }

    public Application(int id) {
        this.id = id;
    }

   

    public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    @Override
    public String toString() {
        return "Application{" + "id=" + id + ", idPost=" + idPost + ", idCandidat=" + idCandidat + ", dateApplication=" + dateApplication + '}'+"\n";
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
        final Application other = (Application) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPost != other.idPost) {
            return false;
        }
        if (this.idCandidat != other.idCandidat) {
            return false;
        }
        if (!Objects.equals(this.dateApplication, other.dateApplication)) {
            return false;
        }
        return true;
    }




}

