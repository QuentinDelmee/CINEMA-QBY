package fr.qby.cinema.bo;
import java.sql.Date;
import java.sql.Time;

public class Movies {
	
	private int id_movie ;
	private int pegi;
	private double average_rating;
	private Time movie_duration;
	private String title;
	private String original_title;
	private String release_date;
	private String movie_genre;
	private String movie_description;
	
	public Movies(
			int id_movie, 
			int pegi, 
			double average_rating, 
			Time movie_duration, 
			String title,
			String original_title, 
			String release_date, 
			String movie_genre, 
			String movie_description) {
		this.id_movie = id_movie;
		this.pegi = pegi;
		this.average_rating = average_rating;
		this.movie_duration = movie_duration;
		this.title = title;
		this.original_title = original_title;
		this.release_date = release_date;
		this.movie_genre = movie_genre;
		this.movie_description = movie_description;
	}

	public int getId_movie() {
		return id_movie;
	}

	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public double getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}

	public Time getMovie_duration() {
		return movie_duration;
	}

	public void setMovie_duration(Time movie_duration) {
		this.movie_duration = movie_duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	public String getMovie_description() {
		return movie_description;
	}

	public void setMovie_description(String movie_description) {
		this.movie_description = movie_description;
	}
	
	
	
}
