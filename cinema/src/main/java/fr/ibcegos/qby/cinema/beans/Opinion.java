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
	@JoinColumn(name = "id_cinema_room")
	private CinemaRoom idCinemaRoom;
	@ManyToOne
	@JoinColumn(name = "id_user")
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
		this.idCinemaRoom = idCinema;
		this.idUser = idUser;
		this.rating = rating;
		this.cleanlyness = cleanlyness;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Opinion [id=" + id + ", idCinema=" + idCinemaRoom.getId() + ", idUser=" + idUser.getId() + ", rating="
				+ rating + ", cleanlyness=" + cleanlyness + "]";
	}

}
