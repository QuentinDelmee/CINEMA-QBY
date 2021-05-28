package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Création des Class Identiques au Bases de données
// Classe "person"
@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String familyName;
	private String firstName; // on ne devrait pas donner un last name pour avoir un nom complet ??
	private LocalDate date;
	private String genre;
	private String city;
	private String email;

	@OneToOne
	@JoinColumn(name = "id_user ")
	private User idUser;

	public Person(String familyName, String firstName, LocalDate date, String genre, String city, String email) {
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
		return "Person [id=" + id + ", familyName=" + familyName + ", firstName=" + firstName + ", date=" + date
				+ ", genre=" + genre + ", city=" + city + ", email=" + email + ", idUser=" + idUser.getId() + "]";
	}

	// Méthode toString pour accéder aux valeurs

}

/*
 * Ci-dessous la Table y correpondant
 * 
 * CREATE TABLE persons ( idperson int NOT NULL AUTOINCREMENT, familyname
 * varchar (50), firstname varchar (50), birthdate date, genre varchar (50),
 * city varchar (50), email varchar (50), PRIMARY KEY (idpersonnes) );
 * 
 */
