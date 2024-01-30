package com.example.demo.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "liste_cadeau")
public class ListeCadeau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @OneToMany(mappedBy = "listeCadeau", cascade = CascadeType.ALL)
    private List<Cadeau> cadeaux;

    // Constructeurs, getters, setters (selon vos besoins)
}
