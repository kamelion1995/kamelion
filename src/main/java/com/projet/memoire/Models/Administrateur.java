package com.projet.memoire.Models;

import javax.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idadmin;
    private String nom;
    private String prenom;
    private int age ;
    private String telephone;
    private String emailId;
    private String adresse;
    private String password;


    public Long getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Long idadmin) {
        this.idadmin = idadmin;
    }

    public String getPassword() {
        return password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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




    @Override
    public String toString() {
        return "Administrateur{" +
                "id=" + getIdadmin() +
                ", nom=" + nom +
                ", prenom=" + prenom+
                ", email=" + emailId+
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", password='" + password + '\'' +


                '}';
    }

    public Administrateur(Long idadmin, String nom, String prenom, int age, String telephone, String emailId, String adresse, String password) {
        super();
        this.idadmin = idadmin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
        this.adresse = adresse;
        this.emailId=emailId;
        this.password=password;

    }
    public Administrateur(){
        super();
    }
}


