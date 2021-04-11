package fr.qby.cinema.bo;

import java.time.LocalDate;

public class Seances {
	private int id_seance ;
	private Salles id_salles ;
	private Films id_films ;
	private LocalDate date ;
	private int nbPlacesLeft ;
	
	public Seances(int id_seance, Salles id_salles, Films id_films, LocalDate date, int nbPlacesLeft) {
		this.id_seance = id_seance;
		this.id_salles = id_salles;
		this.id_films = id_films;
		this.date = date;
		this.nbPlacesLeft = nbPlacesLeft;
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

	public Films getId_films() {
		return id_films;
	}

	public void setId_films(Films id_films) {
		this.id_films = id_films;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNbPlacesLeft() {
		return nbPlacesLeft;
	}

	public void setNbPlacesLeft(int nbPlacesLeft) {
		this.nbPlacesLeft = nbPlacesLeft;
	}
	
	
	
}
