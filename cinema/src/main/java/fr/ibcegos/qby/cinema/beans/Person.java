package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDate;

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
	private Integer  idperson;
	private String familyname;
	private String firstname; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private LocalDate date;   	
	private String genre;
	private String city;
	private String email;
	
	
	
	// Constructeur avec paramètre
	public Person(Integer idperson, String familyname, String firstname, LocalDate date, String genre, String city, String email) {
		this.idperson = idperson;
		this.familyname = familyname;
		this.firstname = firstname;
		this.date = date;
		this.genre = genre;
		this.city = city;
		this.email = email;
	}
	
	// Constructeur avec paramètre sauf id
		public Person(String familyname, String firstname, LocalDate date, String genre, String city, String email) {
			this.familyname = familyname;
			this.firstname = firstname;
			this.date = date;
			this.genre = genre;
			this.city = city;
			this.email = email;
		}


	
	//Méthode toString pour accéder aux valeurs 
	@Override
	public String toString() {
		return "Person [idperson=" + idperson + ", familyname=" + familyname + ", firstname=" + firstname
				+ ", date=" + date + ", genre=" + genre + ", city=" + city + ", email=" + email + "]";
	}
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
