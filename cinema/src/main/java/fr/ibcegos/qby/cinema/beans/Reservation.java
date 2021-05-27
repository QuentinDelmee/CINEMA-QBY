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
	private Integer idreservation;
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User iduser;
	@ManyToOne
	@JoinColumn ( name = "idseat" )
	private Seat idseat;
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
	public Reservation(User iduser, Seat idseat, LocalDateTime date) {
		super();
		this.iduser = iduser;
		this.idseat = idseat;
		this.date = date;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Reservations [id=" + idreservation + ", iduser=" + iduser + ", idseat=" + idseat + ", date="
				+ date + "]";
	}

}
