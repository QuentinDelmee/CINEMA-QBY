package fr.ibcegos.qby.cinema.beans;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	private String title;
	private String original_title;
	private Integer pegi;
	private Integer release_date;
	private LocalTime movie_duration;
	private String movie_genre;
	private Double average_rating;
	private String movie_description;
	
	@OneToMany(mappedBy="id_movie")
	@JsonBackReference
	private List<Commentary> lstCommentarys = new ArrayList<>();
	
	@OneToMany(mappedBy="id_movie")
	@JsonBackReference
	private List<Session> lstSessions = new ArrayList<>();
	
	
	
	public Movie(Integer pegi, Double average_rating, LocalTime movie_duration, String title, String original_title,
			Integer release_date, String movie_genre, String movie_description) {

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

	public Movie(String title, String original_title, Integer pegi, Integer release_date,
			LocalTime movie_duration, String movie_genre, Double average_rating, String movie_description) {
		this.title = title;
		this.original_title = original_title;
		this.pegi = pegi;
		this.release_date = release_date;
		this.movie_duration = movie_duration;
		this.movie_genre = movie_genre;
		this.average_rating = average_rating;
		this.movie_description = movie_description;
	}
	
	
}
