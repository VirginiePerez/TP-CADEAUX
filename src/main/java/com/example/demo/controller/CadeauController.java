package com.example.demo.controller;
import com.example.demo.model.ListeCadeau;
import com.example.demo.model.Cadeau;
import com.example.demo.service.CadeauDatabase;
import com.example.demo.service.ListeCadeauDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadeaux")
public class CadeauController {

    @Autowired
    private CadeauDatabase cadeauDatabase;

    @Autowired
    private ListeCadeauDatabase listeCadeauDatabase;

    // GET /cadeaux
    @GetMapping
    public List<Cadeau> getAllCadeaux() {
        return cadeauDatabase.getAll();
    }

//    // POST /cadeaux SANS LISTE
//    @PostMapping
//    public void addCadeau(@RequestBody Cadeau cadeau) {
//        cadeauDatabase.add(cadeau);
//    }
@PostMapping("/liste-cadeau")
public ResponseEntity<ListeCadeau> createListeCadeau(@RequestBody ListeCadeau listeCadeau) {
    ListeCadeau createdListeCadeau = listeCadeauDatabase.add(listeCadeau);
    return ResponseEntity.ok(createdListeCadeau);
}
    // POST /cadeaux
    @PostMapping
    public ResponseEntity<Cadeau> addCadeau(@RequestBody Cadeau cadeau) {
        // Récupérer la ListeCadeau associée
        ListeCadeau listeCadeau = listeCadeauDatabase.findById(cadeau.getListeCadeau().getId())
                .orElse(null);
        // Si la ListeCadeau n'est pas trouvée, créer une nouvelle ListeCadeau
        if (listeCadeau == null) {
            listeCadeau = new ListeCadeau();
            // Configurer la nouvelle ListeCadeau selon vos besoins
            listeCadeau = listeCadeauDatabase.add(listeCadeau);
        }
        // Associer la ListeCadeau au Cadeau
        cadeau.setListeCadeau(listeCadeau);
        // Ajouter le Cadeau à la ListeCadeau
        if (listeCadeau.getCadeaux() == null) {
            listeCadeau.setCadeaux(new ArrayList<>());
        }
        listeCadeau.getCadeaux().add(cadeau);

        // Enregistrer la ListeCadeau (cela persistera également le Cadeau en cascade)
        listeCadeauDatabase.update(listeCadeau);

        return ResponseEntity.ok(cadeau);
    }
    // GET /cadeaux/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cadeau> getCadeauById(@PathVariable Integer id) {
        Optional<Cadeau> op = cadeauDatabase.findById(id);
        return op.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /cadeaux/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadeau(@PathVariable Integer id) {
        if (cadeauDatabase.findById(id).isPresent()) {
            cadeauDatabase.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /cadeaux/liste/{listeId}
    @GetMapping("/liste/{listeId}")
    public ResponseEntity<List<Cadeau>> getCadeauxByListeId(@PathVariable Integer listeId) {
        Optional<ListeCadeau> listeCadeau = listeCadeauDatabase.findById(listeId);
        return listeCadeau.map(cadeauDatabase::findAllByListeCadeau)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
