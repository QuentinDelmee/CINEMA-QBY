package fr.qby.cinema.bo;

public class Seats {

	private Cinemas id_Cinema_room;
	private int id_seat;
	private int seat_number;
	private String row_name;
	
	public Seats(Cinemas id_Cinema_room, int id_seat, int seat_number, String row_name) {
		super();
		this.id_Cinema_room = id_Cinema_room;
		this.id_seat = id_seat;
		this.seat_number = seat_number;
		this.row_name = row_name;
	}

	public Cinemas getId_Cinema_room() {
		return id_Cinema_room;
	}

	public void setId_Cinema_room(Cinemas id_Cinema_room) {
		this.id_Cinema_room = id_Cinema_room;
	}

	public int getId_seat() {
		return id_seat;
	}

	public void setId_seat(int id_seat) {
		this.id_seat = id_seat;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getRow_name() {
		return row_name;
	}

	public void setRow_name(String row_name) {
		this.row_name = row_name;
	}

	@Override
	public String toString() {
		return "Seats [id_Cinema_room=" + id_Cinema_room + ", id_seat=" + id_seat + ", seat_number=" + seat_number
				+ ", row_name=" + row_name + "]";
	}
	
	
	
}
