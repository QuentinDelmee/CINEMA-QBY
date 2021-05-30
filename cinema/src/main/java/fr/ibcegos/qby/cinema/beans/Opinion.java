package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Opinion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_cinema", referencedColumnName = "id")
	private CinemaRoom idCinema;
	@ManyToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User idUser;

	private Integer rating;
	private String cleanlyness;

	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param idcinema    CinemaRoom the user wants to rate.
	 * @param iduser      User which rate the CinemaRoom
	 * @param rating      The rating the user will give
	 * @param cleanlyness User's comment.
	 */
	public Opinion(CinemaRoom idCinema, User idUser, Integer rating, String cleanlyness) {
		this.idCinema = idCinema;
		this.idUser = idUser;
		this.rating = rating;
		this.cleanlyness = cleanlyness;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Opinion [id=" + id + ", idCinema=" + idCinema.getId() + ", idUser=" + idUser.getId() + ", rating="
				+ rating + ", cleanlyness=" + cleanlyness + "]";
	}

}
