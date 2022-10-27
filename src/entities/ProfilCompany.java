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
public class ProfilCompany {
    private int id ;
    private String nom ;
    private String prenom ;
    private String addresse ;
    private int code_postal ;
    private String nationalite ;
    private int phone ;
    private String sexe ;
    private String competences ;
    private String language ;
    private String entreprise ;
    private String ecole ;
    private String linkdin ;
    private String github ;
    private float maplong;
    private float maplarg;
    private String image;
    
public ProfilCompany( String nom, String addresse, int code_postal, int phone, float maplong, float maplarg, String linkdin,String image) {
     
        this.nom = nom;
        this.addresse = addresse;
        this.code_postal = code_postal;
        this.phone = phone;
        this.linkdin = linkdin;
        this.maplong = maplong;
        this.maplarg = maplarg;
        this.image = image ;
    }
    
    
    public ProfilCompany(int id, String nom, String addresse, int code_postal, int phone, float maplong, float maplarg, String linkdin) {
        this.id = id;
        this.nom = nom;
        this.addresse = addresse;
        this.code_postal = code_postal;
        this.phone = phone;
        this.linkdin = linkdin;
        this.maplong = maplong;
        this.maplarg = maplarg;
    }
public ProfilCompany( String nom, String addresse, int code_postal, int phone, float maplong, float maplarg, String linkdin) {     
        this.nom = nom;
        this.addresse = addresse;
        this.code_postal = code_postal;
        this.phone = phone;
        this.linkdin = linkdin;
        this.maplong = maplong;
        this.maplarg = maplarg;
    }

    
    public float getMaplong() {
        return maplong;
    }

    public void setMaplong(int maplong) {
        this.maplong = maplong;
    }

    public float getMaplarg() {
        return maplarg;
    }

    public void setMaplarg(int maplarg) {
        this.maplarg = maplarg;
    }
    
    public ProfilCompany(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = "----";
    }

public ProfilCompany(int id, String nom, String prenom, String addresse, int code_postal, String nationalite, int phone, String sexe, String competences, String language, String entreprise, String ecole, String linkdin, String github) {
        this.id = id;
        this.nom = nom;
        this.prenom = "----";
        this.addresse = addresse;
        this.code_postal = code_postal;
        this.nationalite = nationalite;
        this.phone = phone;
        this.sexe = "----";
        this.competences = "----";
        this.language = "----";
        this.entreprise = "----";
        this.ecole = "----";
        this.linkdin = linkdin;
        this.github = github;
    }    

    public ProfilCompany(String nom, String prenom, String addresse, int code_postal, String nationalite, int phone, String sexe, String competences, String language, String entreprise, String ecole, String linkdin, String github) {
        this.nom = nom;
        this.prenom = "----";
        this.addresse = addresse;
        this.code_postal = code_postal;
        this.nationalite = nationalite;
        this.phone = phone;
        this.sexe = "----";
        this.competences = "----";
        this.language = "----";
        this.entreprise = "----";
        this.ecole = "----";
        this.linkdin = linkdin;
        this.github = github;
    }

    public ProfilCompany(int id) {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getLinkdin() {
        return linkdin;
    }

    public void setLinkdin(String linkdin) {
        this.linkdin = linkdin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
     public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Profil{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", addresse=" + addresse + ", code_postal=" + code_postal + ", nationalite=" + nationalite + ", phone=" + phone + ", sexe=" + sexe + ", competences=" + competences + ", language=" + language + ", entreprise=" + entreprise + ", ecole=" + ecole + ", linkdin=" + linkdin + ", github=" + github + '}';
    }

    public String  getImage() {
        return image;
    }
    
    
}
