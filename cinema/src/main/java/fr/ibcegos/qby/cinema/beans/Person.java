package fr.ibcegos.qby.cinema.beans;

// Quand j'ai crée l'attribut de class "Date" je ne s'avais laquelle utiliser entre :
		// import java.sql.Date;   
		// import java.util.Date; --> par logique j'ai choisi celle-ci

//Vers le la ligne "120" il y a la table SQL y correspondant

// Class "util"
import java.util.Date;  

// Création des Class Identiques au Bases de données
	// Classe "person"

public class Person {
	private int  id_person;
	private String family_name;
	private String first_name; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private Date date;   	
	private String genre;
	private String city;
	private String e_mail;
	
	
	
	// Constructeur avec paramètre
	public Person(int id_person, String family_name, String first_name, Date date, String genre, String city, String e_mail) {
		this.id_person = id_person;
		this.family_name = family_name;
		this.first_name = first_name;
		this.date = date;
		this.genre = genre;
		this.city = city;
		this.e_mail = e_mail;
	}


	// Constructeur par défault
	public Person() {
	}
	
	
	//Méthode toString pour accéder aux valeurs 
	@Override
	public String toString() {
		return "L'identifiant : " + id_person 
				+ " de" + genre
				+ " " + family_name 
				+ " " + first_name 
				+ "né(e) le " + date 
				+ " à " + city 			
				+ "e_mail=" + e_mail + "]";
	}

//************************************************************************************//
	// Gettres (pour récupérer-afficher nos attributs de class )
//et   Settres (pour apporter les modifictaions le ac échants) 
	
	public int getId_person() {
		return id_person;
	}


	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	
	public String getFamily_name() {
		return first_name;
	}


	public void setFamily_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getE_mail() {
		return e_mail;
	}


	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
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
