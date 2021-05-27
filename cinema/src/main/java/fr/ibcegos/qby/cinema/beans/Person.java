package fr.ibcegos.qby.cinema.beans;

// Quand j'ai crée l'attribut de class "Date" je ne s'avais laquelle utiliser entre :
		// import java.sql.Date;   
		// import java.util.Date; --> par logique j'ai choisi celle-ci

//Vers le la ligne "120" il y a la table SQL y correspondant

// Class "util"
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;  

// Création des Class Identiques au Bases de données
	// Classe "person"
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	private String familyName;
	private String firstName; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private Date date;   	
	private String genre;
	private String city;
	private String email;
	
	
	
	public Person(String familyName, String firstName, Date date, String genre, String city, String email) {
		super();
		this.familyName = familyName;
		this.firstName = firstName;
		this.date = date;
		this.genre = genre;
		this.city = city;
		this.email = email;
	}



	@Override
	public String toString() {
		return "Person [familyName=" + familyName + ", firstName=" + firstName + ", date=" + date + ", genre=" + genre
				+ ", city=" + city + ", email=" + email + "]";
	}


	
	//Méthode toString pour accéder aux valeurs 









}

/* Ci-dessous la Table y correpondant
 * 
 * CREATE TABLE persons 
	(
		idperson int NOT NULL AUTOINCREMENT,
		familyname varchar (50),
		firstname varchar (50),
		birthdate date,
		genre varchar (50),
		city varchar (50),
		email varchar (50),
		PRIMARY KEY  (idpersonnes)
	);
 * 
 * */
