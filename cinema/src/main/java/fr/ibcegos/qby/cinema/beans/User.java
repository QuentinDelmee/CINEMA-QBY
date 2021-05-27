package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private Integer  iduser;
	private String pseudo;
	private String pwd;
	@OneToOne
	@JoinColumn(name ="idperson")
	private Person idperson;
	
	@ManyToOne
	@JoinColumn(name ="idsl")
	private SecurityLevel  idsl;
	
	
	@OneToMany(mappedBy = "iduser")
	private List<Opinion> myOpinions = new ArrayList<Opinion>();

	
	@OneToMany(mappedBy = "iduser")
	private List<Commentary> myCommentary = new ArrayList<Commentary>();
	
	
	@OneToMany(mappedBy = "iduser")
	private List<Purchase> myPurchase = new ArrayList<Purchase>();
	
	
	@OneToMany(mappedBy = "iduser")
	private List<Reservation> myReservation = new ArrayList<Reservation>();
		
	// Constructeur avec les attributs de Class comme paramètre
	public User(Integer iduser, String pseudo, String pwd, Person idperson, SecurityLevel idsl) {
		this.iduser = iduser;
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.idperson = idperson;
		this.idsl = idsl;
	}
	
	// Constructeur avec paramètre sauf id
	public User(String pseudo, String pwd, Person idperson, SecurityLevel idsl) {
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.idperson = idperson;
		this.idsl = idsl;
	}


	
	// Méthode toString pour accéder aux valeurs 
	
	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", pseudo=" + pseudo + ", pwd=" + pwd + ", idperson=" + idperson
				+ ", idsl=" + idsl + "]";
	}
	
	
}



/*
	CREATE TABLE users 
	(
		iduser int NOT NULL AUTOINCREMENT , 
		pseudo varchar (50),
		pwd varchar (50),
		idperson int,	
		idsl int,
		PRIMARY KEY (idusers),
		FOREIGN KEY (idperson) REFERENCES persons(idperson),
		FOREIGN KEY (idsl) REFERENCES securitylevel(idsl)
	);

*/