package com.projet.memoire.Models;

import javax.persistence.*;

@Entity
@Table(name = "provenance")
public class Provenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpro;
    private String nom;
    private String type;
    private String telephone;
    private String emailId;
    private String adresse;
    private String password;
    private String ville;
    private String paye;


    public Long getIdpro() {
        return idpro;
    }

    public void setIdpro(Long idpro) {
        this.idpro = idpro;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Provenance{" +
                "id=" + getIdpro() +
                ", email=" + emailId+
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", paye='" + paye + '\'' +


                '}';
    }

    public Provenance(Long idpro,String telephone,String nom, String emailId, String adresse, String type, String password, String ville,String paye) {
        super();
        this.idpro = idpro;
        this.telephone = telephone;
        this.adresse = adresse;
        this.emailId=emailId;
        this.type=type;
        this.password=password;
        this.nom=nom;
        this.paye=paye;
        this.ville=ville;


    }
    public Provenance(){
        super();
    }

}
