package fr.ibcegos.qby.cinema.beans;
//Création des Class Identiques au Bases de données
	// Classe "products"

//Vers le la ligne "106" il y a la table SQL y correspondant

import java.sql.Date;

public class Product {
	private int  id_product ;
	private String product_name ;
	private double price ;
	private String category ;
	private String product_description ;
	
	
	// Constrcuteur par défaut
	public Product() {
		
	}


	// Constructeur avec paramètre les attributs de class
	
	public Product(int id_product, String product_name, double price, String category, String product_description) {
		this.id_product = id_product;
		this.product_name = product_name;
		this.price = price;
		this.category = category;
		this.product_description = product_description;
	}


	// Méthode toString pour accéder aux valeurs 
	
	
	@Override
	public String toString() {
		return " " + id_product 
				   + " a été vendu au prix de " + price
				+ " " + product_name 
				+ " .Il s'agit de " + category 
				+ " " + product_description + "]";
	}
	
	
	
	
	
	
	
//************************************************************************************//
	// Getters et Settres
	
	
	public int getId_product() {
		return id_product;
	}


	public void setId_product(int id_product) {
		this.id_product = id_product;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getProduct_description() {
		return product_description;
	}


	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	
}
//************************************************************************************//

/* Ci-dessous la Table y correpondant
 * 
 * 	CREATE TABLE products 
	(
		id_product int NOT NULL AUTO_INCREMENT,
		product_name varchar (50),
		price decimal (6,2),
		category varchar (50),
		product_description text,
		PRIMARY KEY (id_product)
	);
 * 
 * 
 * 
 */
