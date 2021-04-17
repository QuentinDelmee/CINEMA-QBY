package fr.qby.cinema.bo;
import java.sql.Date;

public class Movies {
	
	private int id_movie ;
	private int pegi;
	private double average_rating;
	private time time_duration;
	private String title;
	private String original_title;
	private String release_date;
	private String genre;
	private String description;
	
	public Movies(
		int id_movie,
		int pegi,
		double average_rating,
		time time_duration,
		String title,
		String release_date,
		String genre,
		String description
	){
		this.id_movie = id_movie;
		this.pegi = pegi;
		this.average_rating = average_rating;
		this.time_duration = time_duration;
		this.title = title;
		this.release_date = release_date;
		this.genre = genre;
		this.description = description;
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

	public time getTime_duration() {
		return time_duration;
	}

	public void setTime_duration(time time_duration) {
		this.time_duration = time_duration;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
