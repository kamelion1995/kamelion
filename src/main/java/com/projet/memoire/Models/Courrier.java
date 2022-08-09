package com.projet.memoire.Models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Courrier")
public class Courrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long refCourrier;
    private Date date;
    private String objet;
    private String details;
    private boolean etat;




    public Long getRefCourrier() {
        return refCourrier;
    }

    public void setRefCourrier(Long refCourrier) {
        this.refCourrier = refCourrier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    @Override
    public String toString() {
        return "Courrier{" +
                "refcourrier=" + getRefCourrier() +
                ", date=" + date +
                ", objet=" + objet+
                ", details=" + details+
                ", etat=" + etat +
                '}';
    }

    public Courrier(Long refCourrier, Date date, String objet, String details, boolean etat) {
        super();
        this.refCourrier = refCourrier;
        this.date = date;
        this.objet = objet;
        this.details = details;
        this.etat = etat;

    }
    public Courrier(){
        super();
    }
}
