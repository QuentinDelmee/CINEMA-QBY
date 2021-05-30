package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User idUser;
	@ManyToOne
	@JoinColumn(name = "id_seat", referencedColumnName = "id")
	private Seat idSeat;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime idDate;

	/**
	 * Constructor of the class, all other functions are automated with Lombok
	 * 
	 * @param idusers User which is reserving a seat for a film on a specific
	 *                session
	 * @param idseat  Seat reserved by the user inside the CinemaRoom
	 * @param idDate    Date of the reservation which corresponds to the start of a
	 *                film session
	 */

	public Reservation(User idUser, Seat idSeat, LocalDateTime idDate) {
		super();
		this.idUser = idUser;
		this.idSeat = idSeat;
		this.idDate = idDate;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", idUser=" + idUser.getId() + ", idSeat=" + idSeat.getId() + ", idDate=" + idDate
				+ "]";
	}

}
