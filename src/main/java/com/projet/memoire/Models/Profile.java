package com.projet.memoire.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idp;
    private String nom;

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        return "Agent{" +
                "id=" + getIdp() +
                ", nom=" + nom +


                '}';
    }

    public Profile(Long idp, String nom) {
        super();
        this.idp = idp;
        this.nom = nom;

    }

    public Profile(){
        super();
    }
}
