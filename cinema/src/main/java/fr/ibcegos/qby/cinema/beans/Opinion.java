package fr.ibcegos.qby.cinema.beans;

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
public class Opinion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_opinion;

	private CinemaRoom id_cinema;
	private User id_users;
	private Double rating;
	private String cleanlyness;

	public Opinion(CinemaRoom id_cinema, User id_users, Double rating, String cleanlyness) {
		super();
		this.id_cinema = id_cinema;
		this.id_users = id_users;
		this.rating = rating;
		this.cleanlyness = cleanlyness;
	}

	@Override
	public String toString() {
		return "Opinion [id_opinion=" + id_opinion + ", id_cinema=" + id_cinema + ", id_users=" + id_users + ", rating="
				+ rating + ", cleanlyness=" + cleanlyness + "]";
	}
	
	

}
