package com.example.demo;

import com.example.demo.model.Cadeau;
import com.example.demo.service.CadeauDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	CadeauDatabase cadeauDatabase;


	@Test
	void testAnnuaireCadeau() {
		Cadeau jouet1 = new Cadeau("Jouet", "barbie", 12);
		cadeauDatabase.add(jouet1);

		Cadeau jouet2 = new Cadeau("Jouet", "lego", 25);
		cadeauDatabase.add(jouet2);

		Cadeau jouet3 = new Cadeau("Jouet", "puzzle", 15);
		cadeauDatabase.add(jouet3);

		Cadeau vetement1 = new Cadeau("Vetement", "pull", 32);
		cadeauDatabase.add(vetement1);

		Cadeau parfum1 = new Cadeau("Parfum", "amor amor", 70);
		cadeauDatabase.add(parfum1);
	}

	// Suppression d'un cadeau avec l'id 1
	@Test
	void testDelete() {
		cadeauDatabase.delete(1);
	}


//	 Recherche d'un cadeau avec l'id 2
	@Test
	void testFindById() {

		Optional<Cadeau> op = cadeauDatabase.findById(2);
		if (op.isEmpty()) {
			System.out.println("Cadeau non trouvé");
		} else {
			Cadeau cadeau = op.get();
			System.out.println(cadeau);
		}
	}




	// Mise à jour du nom d'un cadeau avec l'id 3
	@Test
	void testUpdate() {

		Optional<Cadeau> op = cadeauDatabase.findById(3);
		if (op.isPresent()) {
			Cadeau cadeau = op.get();
			cadeau.setNom("puzzle bois");
			cadeauDatabase.update(cadeau);
		}
	}
}