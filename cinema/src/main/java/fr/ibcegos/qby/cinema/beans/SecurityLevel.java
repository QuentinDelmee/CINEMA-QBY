package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SecurityLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String role;
	private String description;

	@JsonIgnore
	@OneToMany(targetEntity = User.class, mappedBy = "idSecurityLevel", cascade=CascadeType.ALL )
	private List<User> allUsers = new ArrayList<User>();

	public SecurityLevel(String roles, String description) {
		super();
		this.role = roles;
		this.description = description ;
	}

	@Override
	public String toString() {
		return "SecurityLevel [id=" + id + ", role=" + role + ", description=" + description + "]";
	}

	// Méthode toString pour accéder aux valeurs

}

/*
 * Ci-dessous la Table y correpondant
 * 
 * CREATE TABLE securitylevel ( idsl int NOT NULL AUTOINCREMENT, roles varchar
 * (50), PRIMARY KEY (idsl)
 * 
 * );
 * 
 */