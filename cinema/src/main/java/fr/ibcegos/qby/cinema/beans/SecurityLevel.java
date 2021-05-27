package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Création des Class Identiques au Bases de données
	// Classe "securitylevel"

//Vers le la ligne "54" il y a la table SQL y correspondant
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SecurityLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idsl;
	private String roles;
	
	@OneToMany(mappedBy = "iduser")
	private List<User> allUsers = new ArrayList<User>();
	
	// Constructeur avec les attributs de Class comme paramètre
	public SecurityLevel(Integer idsl, String roles) {
		this.idsl = idsl;
		this.roles = roles;
	}
	
	// Constructeur avec paramètre sauf id
	public SecurityLevel(String roles) {
		this.roles = roles;
	}


	
	// Méthode toString pour accéder aux valeurs 
	@Override
	public String toString() {
		return "SecurityLevel [idsl=" + idsl + ", roles=" + roles + "]";
	}
	
}



/* Ci-dessous la Table y correpondant
 * 
 * 	CREATE TABLE securitylevel 
	(
		idsl int NOT NULL AUTOINCREMENT,
		roles varchar (50),
		PRIMARY KEY (idsl)
	
	);
 
 */