package fr.ibcegos.qby.cinema.beans;

import java.sql.Time;
import java.util.List;

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
/**
 * 
 * @author QBY
 *
 */
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_movie;
	
	private Integer pegi;
	private Double average_rating;
	private Time movie_duration;
	private String title;
	private String original_title;
	private String release_date;
	private String movie_genre;
	private String movie_description;
	
	public Movie(Integer pegi, Double average_rating, Time movie_duration, String title, String original_title,
			String release_date, String movie_genre, String movie_description) {

		this.pegi = pegi;
		this.average_rating = average_rating;
		this.movie_duration = movie_duration;
		this.title = title;
		this.original_title = original_title;
		this.release_date = release_date;
		this.movie_genre = movie_genre;
		this.movie_description = movie_description;
	}

	@Override
	public String toString() {
		return "Movie [id_movie=" + id_movie + ", pegi=" + pegi + ", average_rating=" + average_rating
				+ ", movie_duration=" + movie_duration + ", title=" + title + ", original_title=" + original_title
				+ ", release_date=" + release_date + ", movie_genre=" + movie_genre + ", movie_description="
				+ movie_description + "]";
	}
	
	
}
