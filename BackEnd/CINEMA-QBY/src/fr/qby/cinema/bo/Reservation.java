package fr.qby.cinema.bo;

import java.sql.Date;

public class Reservation {
	
	private int id_reservation ;
	private Utilisateurs id_users ;
	private Places id_places ;
	private Date date ;
	
	public Reservation(int id_reservation, Utilisateurs id_users, Places id_places, Date date) {
		this.id_reservation = id_reservation;
		this.id_users = id_users;
		this.id_places = id_places;
		this.date = date;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public Utilisateurs getId_users() {
		return id_users;
	}

	public void setId_users(Utilisateurs id_users) {
		this.id_users = id_users;
	}

	public Places getId_places() {
		return id_places;
	}

	public void setId_places(Places id_places) {
		this.id_places = id_places;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}
