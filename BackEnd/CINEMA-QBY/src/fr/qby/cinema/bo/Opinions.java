package fr.qby.cinema.bo;

public class Opinions {
	private Cinemas id_cinema ;
	private Users id_users ;
	private double rating ;
	private String cleanlyness ;
	
	public Opinions(Cinemas id_cinema, Users id_users, double rating, String cleanlyness) {
		super();
		this.id_cinema = id_cinema;
		this.id_users = id_users;
		this.rating = rating;
		this.cleanlyness = cleanlyness;
	}

	public Cinemas getId_cinema() {
		return id_cinema;
	}

	public void setId_cinema(Cinemas id_cinema) {
		this.id_cinema = id_cinema;
	}

	public Users getId_users() {
		return id_users;
	}

	public void setId_users(Users id_users) {
		this.id_users = id_users;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCleanlyness() {
		return cleanlyness;
	}

	public void setCleanlyness(String cleanlyness) {
		this.cleanlyness = cleanlyness;
	}

	@Override
	public String toString() {
		return "Opinions [id_cinema=" + id_cinema + ", id_users=" + id_users + ", rating=" + rating + ", cleanlyness="
				+ cleanlyness + "]";
	}
	
	
	
	
}
