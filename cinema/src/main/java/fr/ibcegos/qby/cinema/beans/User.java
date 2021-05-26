package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Création des Class Identiques au Bases de données
	// Classe "users"

//Vers le la ligne "94" il y a la table SQL y correspondant

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id_user;
	private String pseudo;
	private String pwd;
	private Person id_person;
	private Security_Level  id_sl;
	
	
	// Constructeur avec les attributs de Class comme paramètre
	public User(Integer id_user, String pseudo, String pwd, Person id_person, Security_Level id_sl) {
		this.id_user = id_user;
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.id_person = id_person;
		this.id_sl = id_sl;
	}
	
	// Constructeur avec paramètre sauf id
	public User(String pseudo, String pwd, Person id_person, Security_Level id_sl) {
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.id_person = id_person;
		this.id_sl = id_sl;
	}


	
	// Méthode toString pour accéder aux valeurs 
	
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", pseudo=" + pseudo + ", pwd=" + pwd + ", id_person=" + id_person
				+ ", id_sl=" + id_sl + "]";
	}
	
	
}



/*
	CREATE TABLE users 
	(
		id_user int NOT NULL AUTO_INCREMENT , 
		pseudo varchar (50),
		pwd varchar (50),
		id_person int,	
		id_sl int,
		PRIMARY KEY (id_users),
		FOREIGN KEY (id_person) REFERENCES persons(id_person),
		FOREIGN KEY (id_sl) REFERENCES security_level(id_sl)
	);

*/