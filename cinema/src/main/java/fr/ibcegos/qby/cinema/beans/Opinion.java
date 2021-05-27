package fr.ibcegos.qby.cinema.beans;

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
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id")
	private CinemaRoom idCinema;
	@ManyToOne
	@JoinColumn(name = "id")
	private User idUser;

	private Integer rating;
	private String cleanlyness;


	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param idcinema   CinemaRoom the user wants to rate.
	 * @param iduser     User which rate the CinemaRoom
	 * @param rating      The rating the user will give
	 * @param cleanlyness User's comment.
	 */
	public Opinion(CinemaRoom idCinema, User idUser, Integer rating, String cleanlyness) {
		this.idCinema = idCinema;
		this.idUser = idUser;
		this.rating = rating;
		this.cleanlyness = cleanlyness;
	}


	@Override
	public String toString() {
		return "Opinion [idCinema=" + idCinema + ", idUser=" + idUser + ", rating=" + rating + ", cleanlyness="
				+ cleanlyness + "]";
	}

	/**
	 * Function which returns a JSON string of the class.
	 */

	
}
