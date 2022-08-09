package com.projet.memoire.Models;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idu;
    private String username;
    private String password;
    @ManyToOne
    private Profile profile;


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
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



    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + getIdu() +
                ", username=" + username +
                ", password=" + password+

                '}';
    }


    public Utilisateur(Long idu, String username, String password,Profile profile) {
        this.idu = idu;
        this.username = username;
        this.password = password;
        this.profile=profile;

    }

    public Utilisateur(){
        super();
    }
}
