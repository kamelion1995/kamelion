package com.projet.memoire.Models;


import javax.persistence.*;

@Entity
@Table(name = "typeCourrier")

public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idType;
    private String type;

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Type{" +
                "idType=" + getIdType() +
                ", type=" + type +

                '}';
    }

    public Type(Long idType, String type) {
        super();
        this.idType = idType;
        this.type = type;
    }
 public  Type(){
        super();
 }
}
