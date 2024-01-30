package com.example.demo.service;

import com.example.demo.dao.ListeCadeauRepository;
import com.example.demo.model.ListeCadeau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListeCadeauDatabase {

    @Autowired
    private ListeCadeauRepository listeCadeauRepository;

    public ListeCadeau add(ListeCadeau listeCadeau) {
        listeCadeauRepository.save(listeCadeau);
        return listeCadeau;
    }

    public List<ListeCadeau> getAll() {
        return listeCadeauRepository.findAll();
    }

    public Optional<ListeCadeau> findById(Integer id) {
        return listeCadeauRepository.findById(id);
    }

    public void delete(Integer id) {
        listeCadeauRepository.deleteById(id);
    }

    public void update(ListeCadeau listeCadeau) {
        listeCadeauRepository.save(listeCadeau);
    }
}
