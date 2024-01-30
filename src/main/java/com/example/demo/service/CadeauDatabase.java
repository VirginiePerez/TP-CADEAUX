package com.example.demo.service;

import com.example.demo.dao.CadeauRepository;
import com.example.demo.model.ListeCadeau;
import com.example.demo.model.Cadeau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadeauDatabase {

    @Autowired
    private CadeauRepository cadeauRepository;

    public void add( Cadeau c){
        cadeauRepository.save(c);
    }

    public List<Cadeau> getAll(){
        return cadeauRepository.findAll();
    }

    public Optional<Cadeau> findById(Integer id){
        return cadeauRepository.findById(id);
    }

    public void delete(Integer id) {
        cadeauRepository.deleteById(id);
    }

    public void update(Cadeau cadeau) {
        cadeauRepository.save(cadeau);
    }

    public List<Cadeau> findAllByListeCadeau(ListeCadeau listeCadeau) {
        return cadeauRepository.findAllByListeCadeau(listeCadeau);
    }
}