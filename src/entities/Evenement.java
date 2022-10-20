/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Evenement {
    private int id_ev;
    private String nom_ev;
    private String date_debut_ev;
    private String date_fin_ev;
    private int organisateur_ev;
    private String lieu_ev;
    private String disponibilite_ev;
    private String programme_ev;
    private int num_contact;

    public Evenement(String text, Date datestart, Date dateend, int nbr1, String text0, String text1, String text2, int nbr2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_ev=" + id_ev + ", nom_ev=" + nom_ev + ", date_debut_ev=" + date_debut_ev + ","
                + " date_fin_ev=" + date_fin_ev + ", organisateur_ev=" + organisateur_ev + ", lieu_ev=" + lieu_ev + ", disponibilite_ev=" + disponibilite_ev + ", programme_ev=" + programme_ev + ", num_contact=" + num_contact + '}';
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    public String getDate_debut_ev() {
        return date_debut_ev;
    }

    public void setDate_debut_ev(String date_debut_ev) {
        this.date_debut_ev = date_debut_ev;
    }

    public String getDate_fin_ev() {
        return date_fin_ev;
    }

    public void setDate_fin_ev(String date_fin_ev) {
        this.date_fin_ev = date_fin_ev;
    }

    public int getOrganisateur_ev() {
        return organisateur_ev;
    }

    public void setOrganisateur_ev(int organisateur_ev) {
        this.organisateur_ev = organisateur_ev;
    }

    public String getLieu_ev() {
        return lieu_ev;
    }

    public void setLieu_ev(String lieu_ev) {
        this.lieu_ev = lieu_ev;
    }

    public String getDisponibilite_ev() {
        return disponibilite_ev;
    }

    public void setDisponibilite_ev(String disponibilite_ev) {
        this.disponibilite_ev = disponibilite_ev;
    }

    public String getProgramme_ev() {
        return programme_ev;
    }

    public void setProgramme_ev(String programme_ev) {
        this.programme_ev = programme_ev;
    }

    public int getNum_contact() {
        return num_contact;
    }

    public void setNum_contact(int num_contact) {
        this.num_contact = num_contact;
    }

    public Evenement(int id_ev) {
        this.id_ev = id_ev;
    }

    public Evenement() {
    }

    public Evenement(String nom_ev, String date_debut_ev, String date_fin_ev, int organisateur_ev, String lieu_ev, String disponibilite_ev, String programme_ev, int num_contact) {
        this.nom_ev = nom_ev;
        this.date_debut_ev = date_debut_ev;
        this.date_fin_ev = date_fin_ev;
        this.organisateur_ev = organisateur_ev;
        this.lieu_ev = lieu_ev;
        this.disponibilite_ev = disponibilite_ev;
        this.programme_ev = programme_ev;
        this.num_contact = num_contact;
    }

    public Evenement(int id_ev, String nom_ev, String date_debut_ev, String date_fin_ev, int organisateur_ev, String lieu_ev, String disponibilite_ev, String programme_ev, int num_contact) {
        this.id_ev = id_ev;
        this.nom_ev = nom_ev;
        this.date_debut_ev = date_debut_ev;
        this.date_fin_ev = date_fin_ev;
        this.organisateur_ev = organisateur_ev;
        this.lieu_ev = lieu_ev;
        this.disponibilite_ev = disponibilite_ev;
        this.programme_ev = programme_ev;
        this.num_contact = num_contact;
    }

    } 

