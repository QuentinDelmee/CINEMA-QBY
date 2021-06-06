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
	private Integer id;
	private String productName;
	private Double price;
	private String category;
	private String productDescription;

	public Product(String productName, Double price, String category, String productDescription) {

		this.productName = productName;
		this.price = price;
		this.category = category;
		this.productDescription = productDescription;

	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", category=" + category
				+ ", productDescription=" + productDescription + "]";
	}

}
//************************************************************************************//

/*
 * Ci-dessous la Table y correpondant
 * 
 * CREATE TABLE products ( idproduct int NOT NULL AUTOINCREMENT, productname
 * varchar (50), price decimal (6,2), category varchar (50), productdescription
 * text, PRIMARY KEY (idproduct) );
 * 
 * 
 * 
 */