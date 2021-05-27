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
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id")
	private User idUser;
	@ManyToOne
	@JoinColumn ( name = "id" )
	private Seat idSeat;
	private LocalDateTime date;

	/**
	 * Constructor of the class, all other functions are automated with Lombok
	 * 
	 * @param idusers User which is reserving a seat for a film on a specific
	 *                 session
	 * @param idseat  Seat reserved by the user inside the CinemaRoom
	 * @param date     Date of the reservation which corresponds to the start of a
	 *                 film session
	 */

	public Reservation(User idUser, Seat idSeat, LocalDateTime date) {
		super();
		this.idUser = idUser;
		this.idSeat = idSeat;
		this.date = date;
	}


	/**
	 * Function which returns a JSON string of the class.
	 */

	@Override
	public String toString() {
		return "Reservation [idUser=" + idUser + ", idSeat=" + idSeat + ", date=" + date + "]";
	}


}
