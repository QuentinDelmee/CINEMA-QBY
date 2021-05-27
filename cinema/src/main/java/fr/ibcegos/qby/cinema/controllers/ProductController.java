package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Product;
import fr.ibcegos.qby.cinema.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	public ProductService productService;
	
	//////////
	//CREATE//
	//////////
	
	@PostMapping("/REST/product")
	public void createProduit(@RequestBody Product product) {
		productService.create(product);
	}
	
	//////////
	// GET  //
	//////////
	//Récupérer un produit par son id
	@GetMapping("/REST/productById/{id}")
	public Product getProductById(@PathVariable ("id") Integer id_product) {
		return productService.getProductById(id_product);
	}
	
	//Récupérer tous les produits
	@GetMapping("/REST/product")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	
	//////////
	//UPDATE//
	//////////
	@PutMapping("/REST/product")
	public void update(Product product) {
		productService.update(product);
	}
	
	//////////
	//DELETE//
	//////////
	//Effacer tous les produits
	
<<<<<<< HEAD
	@DeleteMapping("/REST/deleteProductById")
	public void deleteAll(@RequestBody Product product) {
=======
	@DeleteMapping("/REST/product")
	public void deleteAll(Product product) {
>>>>>>> 2581c3120336a06d848e1f62f57ac27255b448c8
		productService.delete(product);
	}
	
	//Effacer un produit par son id
	@DeleteMapping("/REST/deleteProductById/{id}")
	public void deleteProductById(@PathVariable("id") Integer id_product) {
		productService.deleteProductById(id_product);
	}
} //---> ici se termine ma class
