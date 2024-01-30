package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="cadeaux")
public class Cadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String nom;
    private String description;
    private Integer prix;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "liste_cadeau_id")
    private ListeCadeau listeCadeau;


    public Cadeau(String nom, String description, Integer prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Cadeau() {
    }
    @JsonIgnore
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

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }


    @JsonProperty("prix")
    public String getPrixFormatted() {
        return prix + " €";
    }

    public ListeCadeau getListeCadeau() {
        return listeCadeau;
    }

    public void setListeCadeau(ListeCadeau listeCadeau) {
        this.listeCadeau = listeCadeau;
    }
}
