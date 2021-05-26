package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Product;
import fr.ibcegos.qby.cinema.daos.ProductDAO;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void create(Product product) {
		productDAO.save(product);
	}

	@Override
	public Product getProductById(Integer id_product) {
		return productDAO.findById(id_product).orElse(null);
	}

	@Override
	public List<Product> getAllProduct() {
		return (List<Product>) productDAO.findAll();
	}

	@Override
	public void update(Product product) {
		productDAO.save(product);		
	}

	@Override
	public void delete(Product product) {
		productDAO.delete(product);	
	}

	@Override
	public void deleteProductById(Integer id_product) {
		productDAO.deleteById(id_product);
	}

}
