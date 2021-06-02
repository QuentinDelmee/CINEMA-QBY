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
 * Class to stock and manage films in cinemarooms at given dates
 * 
 * @author QBY
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_cinema_room", referencedColumnName = "id")
	private CinemaRoom idCinemaRoom;
	@ManyToOne
	@JoinColumn(name = "id_movie", referencedColumnName = "id")
	private Movie idMovie;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime idDate;
	private Integer seatsLeft;

	/**
	 * Constructor of the class, all other functions are automated with Lombok
	 * 
	 * @param idcinema  The room in which the film is projected
	 * @param idmovie   The movie which will be projected
	 * @param iddate    The starting date of the movie
	 * @param seatsleft The number of seats left in the room
	 */
	public Session(CinemaRoom idCinema, Movie idMovie, LocalDateTime idDate, Integer seatsLeft) {
		super();
		this.idCinemaRoom = idCinema;
		this.idMovie = idMovie;
		this.idDate = idDate;
		this.seatsLeft = seatsLeft;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Session [id=" + id + ", idCinema=" + idCinemaRoom.getId() + ", idMovie=" + idMovie.getId() + ", idDate="
				+ idDate + ", seatsLeft=" + seatsLeft + "]";
	}

}
