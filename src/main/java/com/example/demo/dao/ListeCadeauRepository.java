package com.example.demo.dao;

import com.example.demo.model.ListeCadeau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeCadeauRepository extends JpaRepository<ListeCadeau, Integer> {

}

