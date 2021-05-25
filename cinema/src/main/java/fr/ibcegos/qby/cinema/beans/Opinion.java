package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Class which allow the user to rate the cleanlyness of a CinemaRoom
 * 
 * @author QBY
 *
 */
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

	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param id_cinema   CinemaRoom the user wants to rate.
	 * @param id_users    User which rate the CinemaRoom
	 * @param rating      The rating the user will give
	 * @param cleanlyness User's comment.
	 */
	public Opinion(CinemaRoom id_cinema, User id_users, Double rating, String cleanlyness) {
		super();
		this.id_cinema = id_cinema;
		this.id_users = id_users;
		this.rating = rating;
		this.cleanlyness = cleanlyness;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Opinion [id_opinion=" + id_opinion + ", id_cinema=" + id_cinema + ", id_users=" + id_users + ", rating="
				+ rating + ", cleanlyness=" + cleanlyness + "]";
	}

}
