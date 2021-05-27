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
	private Integer  id;
	private String pseudo;
	private String pwd;
	@OneToOne
	@JoinColumn(name ="id")
	private Person idPerson;
	
	@ManyToOne
	@JoinColumn(name ="id")
	private SecurityLevel idSecurityLevel;
	
	
	@OneToMany(mappedBy = "id")
	private List<Opinion> myOpinions = new ArrayList<Opinion>();

	
	@OneToMany(mappedBy = "id")
	private List<Commentary> myCommentary = new ArrayList<Commentary>();
	
	
	@OneToMany(mappedBy = "id")
	private List<Purchase> myPurchase = new ArrayList<Purchase>();
	
	
	@OneToMany(mappedBy = "id")
	private List<Reservation> myReservation = new ArrayList<Reservation>();
		

	public User(String pseudo, String pwd, Person idPerson, SecurityLevel idSecurityLevel, List<Opinion> myOpinions,
			List<Commentary> myCommentary, List<Purchase> myPurchase, List<Reservation> myReservation) {
		super();
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.idPerson = idPerson;
		this.idSecurityLevel = idSecurityLevel;
		this.myOpinions = myOpinions;
		this.myCommentary = myCommentary;
		this.myPurchase = myPurchase;
		this.myReservation = myReservation;
	}


	@Override
	public String toString() {
		return "User [pseudo=" + pseudo + ", pwd=" + pwd + ", idPerson=" + idPerson + ", idSecurityLevel="
				+ idSecurityLevel + ", myOpinions=" + myOpinions + ", myCommentary=" + myCommentary + ", myPurchase="
				+ myPurchase + ", myReservation=" + myReservation + "]";
	}

	
	// Méthode toString pour accéder aux valeurs 
	







	
	
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