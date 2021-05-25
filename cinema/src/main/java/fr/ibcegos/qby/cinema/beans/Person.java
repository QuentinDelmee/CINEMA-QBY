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
	private Integer  id_person;
	private String family_name;
	private String first_name; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private Date date;   	
	private String genre;
	private String city;
	private String e_mail;
	
	
	
	// Constructeur avec paramètre
	public Person(Integer id_person, String family_name, String first_name, Date date, String genre, String city, String e_mail) {
		this.id_person = id_person;
		this.family_name = family_name;
		this.first_name = first_name;
		this.date = date;
		this.genre = genre;
		this.city = city;
		this.e_mail = e_mail;
	}
	
	// Constructeur avec paramètre sauf id
		public Person(String family_name, String first_name, Date date, String genre, String city, String e_mail) {
			this.family_name = family_name;
			this.first_name = first_name;
			this.date = date;
			this.genre = genre;
			this.city = city;
			this.e_mail = e_mail;
		}


	
	//Méthode toString pour accéder aux valeurs 
	@Override
	public String toString() {
		return "Person [id_person=" + id_person + ", family_name=" + family_name + ", first_name=" + first_name
				+ ", date=" + date + ", genre=" + genre + ", city=" + city + ", e_mail=" + e_mail + "]";
	}
}

/* Ci-dessous la Table y correpondant
 * 
 * CREATE TABLE persons 
	(
		id_person int NOT NULL AUTO_INCREMENT,
		family_name varchar (50),
		first_name varchar (50),
		birthdate date,
		genre varchar (50),
		city varchar (50),
		e_mail varchar (50),
		PRIMARY KEY  (id_personnes)
	);
 * 
 * */
