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

/**
 * Controller class for Purchase with basic CRUDs Mapping
 * 
 * @author QBY
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {
	@Autowired
	private PurchaseService pservice;

	/**
	 * Initialization function to potentially add data in DB
	 */
	@PostConstruct
	@Transactional
	public void init() {

	}

	/**
	 * Function to Map getPurchase to an URL
	 * 
	 * @param id the id of the Purchase we want to get
	 * @return the Purchase found in the DB (null if absent)
	 */
	@GetMapping("/REST/purchase/{id}")
	public List<Purchase> getFromId(@PathVariable("id") Integer id) {
		return (List<Purchase>) pservice.getPurchase(id);
	}

	/**
	 * Function to Map getAllPurchase to an URL
	 * 
	 * @return the list of all Purchase in DB
	 */
	@GetMapping("/REST/purchase")
	public List<Purchase> getAll() {
		return pservice.getAllPurchase();
	}
	
	/**
	 * Function to Map POST create to an URL
	 * 
	 * @param purchase the purchase posted inside a form
	 * @return the purchase object we obtain
	 */
	@PostMapping("/REST/purchase")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		pservice.create(purchase);
		return purchase;
	}
	
	/**
	 * Function to map PUT update to an URL
	 * 
	 * @param purchase the purchase to update
	 * @return the updated purchase we obtain
	 */
	@PutMapping("/REST/purchase")
	public Purchase updatePurchase(@RequestBody Purchase purchase) {
		pservice.update(purchase);
		return purchase;
	}
	
	/**
	 * Function to Map DELETE deleteById to an URL
	 * 
	 * @param id the id of the purchase to delete
	 */
	@DeleteMapping("/REST/purchase/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		pservice.deleteById(id);
	}
}
