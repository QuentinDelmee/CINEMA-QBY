package fr.qby.cinema.bo;

public class Seats {

	private int id_Cinema_room;
	private int id_seat;
	private int seat_number;
	private String rank;
	
	public Seats(int id_Cinema_room, int id_seat, int seat_number, String rank)
	{
		this.id_Cinema_room = id_Cinema_room;
		this.id_seat = id_seat;
		this.seat_number = seat_number;
		this.rank = rank;
	}

	public int getId_Cinema_room() {
		return id_Cinema_room;
	}

	public void setId_Cinema_room(int id_Cinema_room) {
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}
