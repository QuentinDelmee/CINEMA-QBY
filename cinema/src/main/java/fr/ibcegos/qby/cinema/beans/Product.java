package fr.ibcegos.qby.cinema.beans;
//Création des Class Identiques au Bases de données
	// Classe "products"

//Vers le la ligne "106" il y a la table SQL y correspondant


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id_product ;
	private String product_name ;
	private double price ;
	private String category ;
	private String product_description ;


	// Constructeur avec paramètre les attributs de class
	
	public Product(Integer id_product, String product_name, double price, String category, String product_description) {
		this.id_product = id_product;
		this.product_name = product_name;
		this.price = price;
		this.category = category;
		this.product_description = product_description;
	}

	// Constructeur avec paramètre sauf id
	public Product(String product_name, double price, String category, String product_description) {
		this.product_name = product_name;
		this.price = price;
		this.category = category;
		this.product_description = product_description;
	}

	// Méthode toString pour accéder aux valeurs 

	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", product_name=" + product_name + ", price=" + price
				+ ", category=" + category + ", product_description=" + product_description + "]";
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
