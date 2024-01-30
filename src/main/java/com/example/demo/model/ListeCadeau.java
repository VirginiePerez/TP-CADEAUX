package com.example.demo.model;

import com.example.demo.model.Cadeau;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "liste_cadeau")
public class ListeCadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @OneToMany(mappedBy = "listeCadeau", cascade = CascadeType.PERSIST)
    private List<Cadeau> cadeaux;

    public ListeCadeau() {
    }

    public ListeCadeau(String nom, List<Cadeau> cadeaux) {
        this.nom = nom;
        this.cadeaux = cadeaux;
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

    public List<Cadeau> getCadeaux() {
        return cadeaux;
    }

    public void setCadeaux(List<Cadeau> cadeaux) {
        this.cadeaux = cadeaux;
    }
}
