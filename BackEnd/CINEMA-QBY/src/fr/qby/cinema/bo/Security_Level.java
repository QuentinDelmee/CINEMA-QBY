package fr.qby.cinema.bo;

//Cr�ation des Class Identiques au Bases de donn�es
	// Classe "security_level"

//Vers le la ligne "54" il y a la table SQL y correspondant

public class Security_Level {
	private int id_sl;
	private String roles;
	
	// Constructeur par d�faut
	public Security_Level() {
	}
	// Constructeur avec les attributs de Class comme param�tre
	public Security_Level(int id_sl, String roles) {
		this.id_sl = id_sl;
		this.roles = roles;
	}
	
	// M�thode toString pour acc�der aux valeurs 
	@Override
	public String toString() {
		return "Cette id " + id_sl  
				+ " donne " + roles;
	}
	
	
	//************************************************************************************//
		// Gettres (pour r�cup�rer-afficher nos attributs de class )
	//et   Settres (pour apporter les modifictaions le ac �chants) 
	
	
	public int getId_sl() {
		return id_sl;
	}
	public void setId_sl(int id_sl) {
		this.id_sl = id_sl;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
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