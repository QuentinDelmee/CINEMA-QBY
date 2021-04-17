package fr.qby.cinema.bo;
import java.sql.Date;

public class Salles {
	
	private int cinema_room ;
	private int nb_places;
	private String name;
	private String floor;
	private String screen_size;
	
	public Salles(int cinema_room, int nb_places, String name, string floor, String screen_size) {
		this.cinema_room = cinema_room;
		this.nb_places = nb_places;
		this.name = name;
		this.floor = floor;
		this.screen_size = screen_size;
	}

	public int getCinema_room() {
		return cinema_room;
	}

	public void setCinema_room(int cinema_room) {
		this.cinema_room = cinema_room;
	}

	public int getNb_places() {
		return nb_places;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
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
