package fr.qby.cinema.bo;

import java.time.LocalDate;

public class Sessions {
	private Cinemas id_cinema ;
	private Movies id_movie ;
	private LocalDate id_date ;
	private int seats_left ;
	
	public Sessions(Cinemas id_cinema, Movies id_movie, LocalDate date, int nbPlacesLeft) {
		super();
		this.id_cinema = id_cinema;
		this.id_movie = id_movie;
		this.id_date = date;
		this.seats_left = nbPlacesLeft;
	}

	public Cinemas getId_cinema() {
		return id_cinema;
	}

	public void setId_cinema(Cinemas id_cinema) {
		this.id_cinema = id_cinema;
	}

	public Movies getId_movie() {
		return id_movie;
	}

	public void setId_movie(Movies id_movie) {
		this.id_movie = id_movie;
	}

	public LocalDate getDate() {
		return id_date;
	}

	public void setDate(LocalDate date) {
		this.id_date = date;
	}

	public int getNbPlacesLeft() {
		return seats_left;
	}

	public void setNbPlacesLeft(int nbPlacesLeft) {
		this.seats_left = nbPlacesLeft;
	}

	@Override
	public String toString() {
		return "Sessions [id_cinema=" + id_cinema + ", id_movie=" + id_movie + ", id_date=" + id_date + ", seats_left="
				+ seats_left + "]";
	}
	
	
	
	
}
