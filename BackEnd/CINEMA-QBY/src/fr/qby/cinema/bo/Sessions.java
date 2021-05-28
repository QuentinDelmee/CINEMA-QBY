package fr.qby.cinema.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sessions {
	private CinemasRoom id_cinema ;
	private Movies id_movie ;
	private LocalDateTime id_date ;
	private int seats_left;
	
	public Sessions(CinemasRoom id_cinema, Movies id_movie, LocalDateTime id_date, int seats_left) {
		super();
		this.id_cinema = id_cinema;
		this.id_movie = id_movie;
		this.id_date = id_date;
		this.seats_left = seats_left;
	}
	public Sessions(Movies id_movie, LocalDateTime id_date) {
		this.id_movie = id_movie;
		this.id_date = id_date;
	}

	public CinemasRoom getId_cinema() {
		return id_cinema;
	}

	public void setId_cinema(CinemasRoom id_cinema) {
		this.id_cinema = id_cinema;
	}

	public Movies getId_movie() {
		return id_movie;
	}

	public void setId_movie(Movies id_movie) {
		this.id_movie = id_movie;
	}

	public LocalDateTime getDate() {
		return id_date;
	}

	public void setDate(LocalDateTime date) {
		this.id_date = date;
	}

	public int getSeats_left() {
		return seats_left;
	}

	public void setNbPlacesLeft(int seats_left) {
		this.seats_left = seats_left;
	}

	@Override
	public String toString() {
		return "Sessions [id_cinema=" + id_cinema + ", id_movie=" + id_movie + ", id_date=" + id_date + ", seats_left="
				+ seats_left + "]";
	}
	
	
	
	
}
