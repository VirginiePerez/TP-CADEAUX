package com.example.demo.dao;

import com.example.demo.model.Cadeau;
import com.example.demo.model.ListeCadeau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadeauRepository extends JpaRepository<Cadeau, Integer> {

    List<Cadeau> findAllByNom(String nom);

    List<Cadeau> findAllByListeCadeau(ListeCadeau listeCadeau);
}
