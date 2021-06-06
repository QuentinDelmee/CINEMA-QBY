package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Product;
import fr.ibcegos.qby.cinema.daos.ProductDAO;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;
	
	//////////
	//CREATE//
	//////////
	@Override
	public void create(Product product) {
		productDAO.save(product);
	}
	
	//////////
	// GET  //
	//////////
	//Récupérer un produit par son id
	@Override
	public Product getProductById(Integer id_product) {
		return productDAO.findById(id_product).orElse(null);
	}
	//Récupérer tous les produits
	@Override
	public List<Product> getAllProduct() {
		return (List<Product>) productDAO.findAll();
	}
	
	//////////
	//UPDATE//
	//////////
	@Override
	public void update(Product product) {
		productDAO.save(product);		
	}
	
	
	//////////
	//DELETE//
	//////////
	//Effacer tous les produits
	
	@Override
	public void delete(Product product) {
		productDAO.delete(product);	
	}

	//Effacer un produit par son id
	@Override
	public void deleteProductById(Integer id_product) {
		productDAO.deleteById(id_product);
	}

}
