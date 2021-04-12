package fr.qby.cinema.bo;

public class Salles {
	
	private int id_salles ;
	private String nom;
	private String etage;
	private String taille_ecran;
	private int nombre_de_places;
	
	public Salles(int id_salles, String nom, string etage, String taille_ecran, int nombre_de_places) {
		this.id_salles = id_salles;
		this.nom = nom;
		this.etage = etage;
		this.taille_ecran = taille_ecran;
		this.nombre_de_places = nombre_de_places;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public String getTaille_ecran() {
		return taille_ecran;
	}

	public void setTaille_ecran(String taille_ecran) {
		this.taille_ecran = taille_ecran;
	}

	public int getNombre_de_places() {
		return nombre_de_places;
	}

	public void setNombre_de_places(int nombre_de_places) {
		this.nombre_de_places = nombre_de_places;
	}

	public void setId_salles(int id_salles) {
		this.id_salles = id_salles;
	}

	public int getId_seance() {
		return id_seance;
	}

	public void setId_seance(int id_seance) {
		this.id_seance = id_seance;
	}

	public Salles getId_salles() {
		return id_salles;
	}

	public void setId_salles(Salles id_salles) {
		this.id_salles = id_salles;
	}
		
}
