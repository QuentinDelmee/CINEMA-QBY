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
 * Class to stock and manage films in cinemarooms at given dates
 * 
 * @author QBY
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idcinema")
	private CinemaRoom idcinema;
	@ManyToOne
	@JoinColumn(name = "idmovie")
	private Movie idmovie;
	private LocalDateTime iddate;
	private Integer seatsleft;

	/**
	 * Constructor of the class, all other functions are automated with Lombok
	 * 
	 * @param idcinema  The room in which the film is projected
	 * @param idmovie   The movie which will be projected
	 * @param iddate    The starting date of the movie
	 * @param seatsleft The number of seats left in the room
	 */
	public Session(CinemaRoom idcinema, Movie idmovie, LocalDateTime iddate, Integer seatsleft) {
		super();
		this.idcinema = idcinema;
		this.idmovie = idmovie;
		this.iddate = iddate;
		this.seatsleft = seatsleft;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Session [id=" + id + ", idcinema=" + idcinema + ", idmovie=" + idmovie + ", iddate=" + iddate
				+ ", seatsleft=" + seatsleft + "]";
	}

}
