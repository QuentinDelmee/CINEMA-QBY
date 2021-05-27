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
<<<<<<< HEAD
	private Integer  id;
	private String familyName;
	private String firstName; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private Date date;   	
=======
	private Integer  idperson;
	private String familyname;
	private String firstname; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private LocalDate date;   	
>>>>>>> a874e36af9c68ac8c70804b9e8146b3906c1003d
	private String genre;
	private String city;
	private String email;
	
	
	
<<<<<<< HEAD
	public Person(String familyName, String firstName, Date date, String genre, String city, String email) {
		super();
		this.familyName = familyName;
		this.firstName = firstName;
=======
	// Constructeur avec paramètre
	public Person(Integer idperson, String familyname, String firstname, LocalDate date, String genre, String city, String email) {
		this.idperson = idperson;
		this.familyname = familyname;
		this.firstname = firstname;
>>>>>>> a874e36af9c68ac8c70804b9e8146b3906c1003d
		this.date = date;
		this.genre = genre;
		this.city = city;
		this.email = email;
	}
<<<<<<< HEAD
=======
	
	// Constructeur avec paramètre sauf id
		public Person(String familyname, String firstname, LocalDate date, String genre, String city, String email) {
			this.familyname = familyname;
			this.firstname = firstname;
			this.date = date;
			this.genre = genre;
			this.city = city;
			this.email = email;
		}
>>>>>>> a874e36af9c68ac8c70804b9e8146b3906c1003d



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
