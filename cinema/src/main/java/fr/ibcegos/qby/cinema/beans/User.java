package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String pseudo;
	private String pwd;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_person")
	private Person idPerson;

	@ManyToOne
	@JoinColumn(name = "id_security_level")
	private SecurityLevel idSecurityLevel;

	@JsonIgnore
	@OneToMany(targetEntity = Opinion.class, mappedBy = "idUser", cascade = CascadeType.ALL)
	private List<Opinion> myOpinions = new ArrayList<Opinion>();

	@JsonIgnore
	@OneToMany(targetEntity = Commentary.class, mappedBy = "idUser", cascade = CascadeType.ALL)
	private List<Commentary> myCommentary = new ArrayList<Commentary>();

	@JsonIgnore
	@OneToMany(targetEntity = Purchase.class, mappedBy = "idUser", cascade = CascadeType.ALL)
	private List<Purchase> myPurchase = new ArrayList<Purchase>();

	@JsonIgnore
	@OneToMany(targetEntity = Reservation.class, mappedBy = "idUser", cascade = CascadeType.ALL)
	private List<Reservation> myReservation = new ArrayList<Reservation>();

	public User(String pseudo, String pwd, Person idPerson, SecurityLevel idSecurityLevel) {
		super();
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.idPerson = idPerson;
		this.idSecurityLevel = idSecurityLevel;
	}

	public User(Integer id, String pseudo, String pwd) {

		this.id = id;
		this.pseudo = pseudo;
		this.pwd = pwd;

	}

	@Override
	public String toString() {
		return "User [pseudo=" + pseudo + ", pwd=" + pwd + "]";
	}



	// Méthode toString pour accéder aux valeurs
	

}

/*
 * CREATE TABLE users ( iduser int NOT NULL AUTOINCREMENT , pseudo varchar (50),
 * pwd varchar (50), idperson int, idsl int, PRIMARY KEY (idusers), FOREIGN KEY
 * (idperson) REFERENCES persons(idperson), FOREIGN KEY (idsl) REFERENCES
 * securitylevel(idsl) );
 * 
 */