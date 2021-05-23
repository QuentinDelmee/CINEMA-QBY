package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_reservation;

	private User id_users;
	private Seat id_seat;
	private LocalDateTime date;

	public Reservation(User id_users, Seat id_seat, LocalDateTime date) {
		super();
		this.id_users = id_users;
		this.id_seat = id_seat;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reservations [id=" + id_reservation + ", id_users=" + id_users + ", id_seat=" + id_seat + ", date="
				+ date + "]";
	}

}
