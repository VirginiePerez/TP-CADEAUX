package com.example.demo.model.dao;

import com.example.demo.model.Cadeau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadeauRepository extends JpaRepository<Cadeau, Integer> {
}
