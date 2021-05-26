package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Product;

public interface ProductService {
	//////////
	//CREATE//
	//////////
	
	/**
	 * Créer un produit
	 * @param product
	 */
	public void create(Product  product);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer un produit par son id
	 * @param id_product
	 * @return
	 */
	public Product getProductById(Integer id_product);
	
	/**
	 * Retourne tous les produits
	 * @return
	 */
	public List<Product> getAllProduct();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie un produit
	 * @param product
	 */
	
	public void update(Product product);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime un produit
	 * @param product
	 */
	public void delete(Product product);
	
	
	/**
	 * Supprime un produit par son id
	 * @param id_product
	 */
	public void deleteProductById(Integer id_product);
}
