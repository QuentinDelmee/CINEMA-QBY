package fr.qby.cinema.bo;

import java.sql.Date;

public class Reservations {
	private Users id_users ;
	private Seats id_seat ;
	private Date date ;
	
	public Reservations(Users id_users, Seats id_seat, Date date) {
		super();
		this.id_users = id_users;
		this.id_seat = id_seat;
		this.date = date;
	}

	public Users getId_users() {
		return id_users;
	}

	public void setId_users(Users id_users) {
		this.id_users = id_users;
	}

	public Seats getId_seat() {
		return id_seat;
	}

	public void setId_seat(Seats id_seat) {
		this.id_seat = id_seat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reservations [id_users=" + id_users + ", id_seat=" + id_seat + ", date=" + date + "]";
	}
	
	
	
	
}
