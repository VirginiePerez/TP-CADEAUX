package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name="cadeaux")
public class Cadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String description;
    private String prix;

    public Cadeau(String nom, String description, String prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Cadeau() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
