/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ismail
 */
public class Network { 
            private int iddus ;
            private String discussion;
            private String groupe;
            private String notification ;

    public Network(int iddus, String discussion, String groupe, String notification) {
        this.iddus = iddus;
        this.discussion = discussion;
        this.groupe = groupe;
        this.notification = notification;
    }

    public Network(int iddus) {
        this.iddus = iddus;
    }

    public Network(String discussion, String groupe, String notification) {
        this.discussion = discussion;
        this.groupe = groupe;
        this.notification = notification;
    }
            

    public int getIddus() {
        return iddus;
    }

    public void setIddus(int iddus) {
        this.iddus = iddus;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "Network{" + "iddus=" + iddus + ", discussion=" + discussion + ", groupe=" + groupe + ", notification=" + notification + '}';
    }
                    
    
}
