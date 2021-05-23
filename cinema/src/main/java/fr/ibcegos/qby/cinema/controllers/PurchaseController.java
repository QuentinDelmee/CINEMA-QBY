package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.Purchase;
import fr.ibcegos.qby.cinema.services.PurchaseService;

@RestController
public class PurchaseController {
	@Autowired
	private PurchaseService pservice;
	
	
	
	@PostConstruct
	@Transactional
	public void init() {
		
	}
	
	@GetMapping("/REST/purchase/{id}")
	public List<Purchase> getFromId(@PathVariable("id") Integer id) {
		return pservice.getPurchase(id);
	}

	@GetMapping("/REST/purchase")
	public List<Purchase> getAll() {
		return pservice.getAllPurchase();
	}

	@PostMapping("/REST/purchase")
	public Purchase addAvion(@RequestBody Purchase purchase) {
		pservice.create(purchase);
		return purchase;
	}

	@PutMapping("/REST/purchase")
	public Purchase updateAvion(@RequestBody Purchase purchase) {
		pservice.update(purchase);
		return purchase;
	}
	
	@DeleteMapping("/REST/purchase/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		pservice.deleteById(id);
	}
}
