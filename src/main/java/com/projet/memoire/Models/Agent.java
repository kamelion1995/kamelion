package com.projet.memoire.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idagent;
    private String nom;
    private String prenom;
    private int age ;
    private String telephone;
    private String telephone1;
    private String emailId;
    private String adresse;
    private String matricule;
    private String username;
    private String password;

    @ManyToOne
    private Profile profile;



    public Long getIdagent() {
        return idagent;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setIdagent(Long idagent) {
        this.idagent = idagent;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
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
        return "Agent{" +
                "id=" + getIdagent() +
                ", nom=" + nom +
                ", prenom=" + prenom+
                ", email=" + emailId+
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", telephone1='" + telephone1 + '\'' +
                ", adresse='" + adresse + '\'' +
                ", matricule='" + matricule + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +

                '}';
    }

    public Agent(Long idagent, String nom, String prenom, int age, String telephone, String telephone1, String emailId, String adresse, String matricule, String username, String password, Profile profile) {
        super();
        this.idagent = idagent;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.emailId = emailId;
        this.adresse = adresse;
        this.matricule = matricule;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public Agent(){
        super();
    }
}
