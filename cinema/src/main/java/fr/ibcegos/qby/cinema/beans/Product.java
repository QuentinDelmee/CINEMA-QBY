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
	private Integer  idproduct ;
	private String productname ;
	private double price ;
	private String category ;
	private String productdescription ;


	// Constructeur avec paramètre les attributs de class
	
	public Product(Integer idproduct, String productname, double price, String category, String productdescription) {
		this.idproduct = idproduct;
		this.productname = productname;
		this.price = price;
		this.category = category;
		this.productdescription = productdescription;
	}

	// Constructeur avec paramètre sauf id
	public Product(String productname, double price, String category, String productdescription) {
		this.productname = productname;
		this.price = price;
		this.category = category;
		this.productdescription = productdescription;
	}

	// Méthode toString pour accéder aux valeurs 

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", productname=" + productname + ", price=" + price
				+ ", category=" + category + ", productdescription=" + productdescription + "]";
	}
	
	
}
//************************************************************************************//

/* Ci-dessous la Table y correpondant
 * 
 * 	CREATE TABLE products 
	(
		idproduct int NOT NULL AUTOINCREMENT,
		productname varchar (50),
		price decimal (6,2),
		category varchar (50),
		productdescription text,
		PRIMARY KEY (idproduct)
	);
 * 
 * 
 * 
 */
