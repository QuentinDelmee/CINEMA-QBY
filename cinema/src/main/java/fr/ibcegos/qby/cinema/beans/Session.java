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
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private CinemaRoom id_cinema;
	private Movie id_movie;
	private LocalDateTime id_date;
	private Integer seats_left;

	public Session(CinemaRoom id_cinema, Movie id_movie, LocalDateTime id_date, Integer seats_left) {
		super();
		this.id_cinema = id_cinema;
		this.id_movie = id_movie;
		this.id_date = id_date;
		this.seats_left = seats_left;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", id_cinema=" + id_cinema + ", id_movie=" + id_movie + ", id_date=" + id_date
				+ ", seats_left=" + seats_left + "]";
	}
	
	

}
