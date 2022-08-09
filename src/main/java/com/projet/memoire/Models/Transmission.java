package com.projet.memoire.Models;

import javax.persistence.*;


@Entity
@Table(name = "Canal")
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libcanal;
    private String reference;


    @OneToOne
    private Courrier courrier;



    @ManyToOne
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }


    public Courrier getCourrier() {
        return courrier;
    }

    public void setCourrier(Courrier courrier) {
        this.courrier = courrier;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibcanal() {
        return libcanal;
    }

    public void setLibcanal(String libCanal) {
        this.libcanal = libCanal;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Transmission(Long id, String libCanal, String reference, Profile profile, Courrier courrier) {

        super();
        this.id = id;
        this.libcanal = libCanal;
        this.reference = reference;
        this.profile=profile;
        this.courrier=courrier;

    }
    public Transmission(){
        super();
    }
}
