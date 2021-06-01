package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/**
 * 
 * @author QBY
 *
 */
public class Commentary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer rating;
	private String commentary;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User idUser;

	@ManyToOne
	@JoinColumn(name = "id_movie")
	private Movie idMovie;

	public Commentary(Integer rating, String commentary, User idUser, Movie idMovie) {

		this.rating = rating;
		this.commentary = commentary;
		this.idUser = idUser;
		this.idMovie = idMovie;
	}

	@Override
	public String toString() {
		return "Commentary [id=" + id + ", rating=" + rating + ", commentary=" + commentary + ", idUser="
				+ idUser.getId() + ", idMovie=" + idMovie.getId() + "]";
	}

}
