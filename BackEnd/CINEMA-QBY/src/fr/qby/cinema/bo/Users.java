package fr.qby.cinema.bo;

import java.sql.Date;

//Création des Class Identiques au Bases de données
	// Classe "users"

//Vers le la ligne "94" il y a la table SQL y correspondant


public class Users {
	private int  id_user;
	private String pseudo;
	private String pwd;
	private Persons id_person;
	private Security_Level  id_sl;
	
	
	// Constructeur par défaut
	public Users() {
	}
	
	// Constructeur avec les attributs de Class comme paramètre
	public Users(int id_user, String pseudo, String pwd, Persons id_person, Security_Level id_sl) {
		this.id_user = id_user;
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.id_person = id_person;
		this.id_sl = id_sl;
	}

	
	// Méthode toString pour accéder aux valeurs 
	@Override
	public String toString() {
		return "" + id_user 
				+ "" + pseudo
				+ " a pour mot de pass " + pwd 
				+ ", correspondant à " + id_person
				+ ", ayant un niveau de sécurité " + id_sl;
	}

	
	//************************************************************************************//
		// Gettres (pour récupérer-afficher nos attributs de class )
	//et   Settres (pour apporter les modifictaions le ac échants) 

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Persons getId_person() {
		return id_person;
	}

	public void setId_person(Persons id_person) {
		this.id_person = id_person;
	}

	public Security_Level getId_sl() {
		return id_sl;
	}

	public void setId_sl(Security_Level id_sl) {
		this.id_sl = id_sl;
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