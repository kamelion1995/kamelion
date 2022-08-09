package com.projet.memoire.Models;


import javax.persistence.*;

@Entity
@Table(name = "Service")

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private String nomService;
    private String responsable;
    private String telService;
    private String emailService;

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTelService() {
        return telService;
    }

    public void setTelService(String telService) {
        this.telService = telService;
    }

    public String getEmailService() {
        return emailService;
    }

    public void setEmailService(String emailService) {
        this.emailService = emailService;
    }
    @Override
    public String toString() {
        return "Service{" +
                "idService=" + getIdService() +
                ", nomService=" + nomService+
                ", responsable=" + responsable+
                ", telService=" + telService+
                ", emailService=" + emailService +
                '}';
    }

    public Service(Long idService, String nomService, String responsable, String telService, String emailService) {
        super();
        this.idService = idService;
        this.nomService = nomService;
        this.responsable = responsable;
        this.telService = telService;
        this.emailService = emailService;
    }
    public Service(){
        super();
    }
}
