/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Participant {
     private int id_pr;
    private int id_ev;
    private int id_user;

    public Participant() {
    }

    public Participant(int id_pr, int id_ev, int id_user) {
        this.id_pr = id_pr;
        this.id_ev = id_ev;
        this.id_user = id_user;
    }

    public Participant(int id_ev, int id_user) {
        this.id_ev = id_ev;
        this.id_user = id_user;
    }

   

  

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Participant{" + "id_pr=" + id_pr + ", id_ev=" + id_ev + ", id_user=" + id_user + '}';
    }


 
    
}
