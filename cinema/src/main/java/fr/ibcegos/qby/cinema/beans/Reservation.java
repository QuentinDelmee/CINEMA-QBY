package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Class to stock and manage users reservations on films
 * 
 * @author QBY
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_reservation;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User id_user;
	@ManyToOne
	@JoinColumn ( name = "id_seat" )
	private Seat id_seat;
	private LocalDateTime date;

	/**
	 * Constructor of the class, all other functions are automated with Lombok
	 * 
	 * @param id_users User which is reserving a seat for a film on a specific
	 *                 session
	 * @param id_seat  Seat reserved by the user inside the CinemaRoom
	 * @param date     Date of the reservation which corresponds to the start of a
	 *                 film session
	 */
	public Reservation(User id_user, Seat id_seat, LocalDateTime date) {
		super();
		this.id_user = id_user;
		this.id_seat = id_seat;
		this.date = date;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Reservations [id=" + id_reservation + ", id_user=" + id_user + ", id_seat=" + id_seat + ", date="
				+ date + "]";
	}

}
