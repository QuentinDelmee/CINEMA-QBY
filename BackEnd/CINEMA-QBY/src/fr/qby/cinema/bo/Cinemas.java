package fr.qby.cinema.bo;
import java.sql.Date;

public class Cinemas {
	
	private int id_Cinema ;
	private int nb_seats;
	private String room_name;
	private String room_level;
	private String screen_size;
	
	public Cinemas(int id_Cinema, int nb_seats, String room_name, String room_level, String screen_size) {
		this.id_Cinema = id_Cinema;
		this.nb_seats = nb_seats;
		this.room_name = room_name;
		this.room_level = room_level;
		this.screen_size = screen_size;
	}

	public int getId_Cinema() {
		return id_Cinema;
	}

	public void setId_Cinema(int id_Cinema) {
		this.id_Cinema = id_Cinema;
	}

	public int getNb_seats() {
		return nb_seats;
	}

	public void setNb_seats(int nb_seats) {
		this.nb_seats = nb_seats;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getRoom_level() {
		return room_level;
	}

	public void setRoom_level(String room_level) {
		this.room_level = room_level;
	}

	public String getScreen_size() {
		return screen_size;
	}

	public void setScreen_size(String screen_size) {
		this.screen_size = screen_size;
	}
	
	
	

}
