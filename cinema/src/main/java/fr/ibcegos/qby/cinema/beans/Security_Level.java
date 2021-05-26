package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Création des Class Identiques au Bases de données
	// Classe "security_level"

//Vers le la ligne "54" il y a la table SQL y correspondant
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Security_Level {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_sl;
	private String roles;

	// Constructeur avec les attributs de Class comme paramètre
	public Security_Level(Integer id_sl, String roles) {
		this.id_sl = id_sl;
		this.roles = roles;
	}
	
	// Constructeur avec paramètre sauf id
	public Security_Level(String roles) {
		this.roles = roles;
	}


	
	// Méthode toString pour accéder aux valeurs 
	@Override
	public String toString() {
		return "Security_Level [id_sl=" + id_sl + ", roles=" + roles + "]";
	}
	
}



/* Ci-dessous la Table y correpondant
 * 
 * 	CREATE TABLE security_level 
	(
		id_sl int NOT NULL AUTO_INCREMENT,
		roles varchar (50),
		PRIMARY KEY (id_sl)
	
	);
 
 */