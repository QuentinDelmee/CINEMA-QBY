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
	@JoinColumn(name = "id_cinema")
	private CinemaRoom id_cinema;
	@ManyToOne
	@JoinColumn(name = "id_movie")
	private Movie id_movie;
	private LocalDateTime id_date;
	private Integer seats_left;

	/**
	 * Constructor of the class, all other functions are automated with Lombok
	 * 
	 * @param id_cinema  The room in which the film is projected
	 * @param id_movie   The movie which will be projected
	 * @param id_date    The starting date of the movie
	 * @param seats_left The number of seats left in the room
	 */
	public Session(CinemaRoom id_cinema, Movie id_movie, LocalDateTime id_date, Integer seats_left) {
		super();
		this.id_cinema = id_cinema;
		this.id_movie = id_movie;
		this.id_date = id_date;
		this.seats_left = seats_left;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Session [id=" + id + ", id_cinema=" + id_cinema + ", id_movie=" + id_movie + ", id_date=" + id_date
				+ ", seats_left=" + seats_left + "]";
	}

}
