package fr.qby.cinema.bo;
import java.sql.Date;

public class Salles {
	
	private int id_Cinema_room ;
	private int nb_seats;
	private String name;
	private String floor;
	private String screen_size;
	
	public Salles(int id_Cinema_room, int nb_seats, String name, string floor, String screen_size) {
		this.id_Cinema_room = id_Cinema_room;
		this.nb_seats = nb_seats;
		this.name = name;
		this.floor = floor;
		this.screen_size = screen_size;
	}

	public int getid_Cinema_room() {
		return id_Cinema_room;
	}

	public void setCinema_room(int id_Cinema_room) {
		this.id_Cinema_room = id_Cinema_room;
	}

	public int getNb_seats() {
		return nb_seats;
	}

	public void setNb_places(int nb_seats) {
		this.nb_seats = nb_seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getScreen_size() {
		return screen_size;
	}

	public void setScreen_size(String screen_size) {
		this.screen_size = screen_size;
	}


}
