package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Commentary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer rating;
	private String commentary;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User idUser;
	
	@ManyToOne
<<<<<<< HEAD
	@JoinColumn(name = "id")
	private Movie idMovie;

	
	public Commentary(Integer rating, String commentary, User idUser, Movie idMovie) {

		this.rating = rating;
		this.commentary = commentary;
		this.idUser = idUser;
		this.idMovie = idMovie;
	}
=======
	@JoinColumn(name = "idmovie")
	private Movie idmovie;

	public Commentary(Integer rating, String commentary, User iduser, Movie idmovie) {
		super();
		this.rating = rating;
		this.commentary = commentary;
		this.iduser = iduser;
		this.idmovie = idmovie;
	} 
>>>>>>> a874e36af9c68ac8c70804b9e8146b3906c1003d
	
	
	@Override
	public String toString() {
		return "Commentary [rating=" + rating + ", commentary=" + commentary + ", idUser=" + idUser + ", idMovie="
				+ idMovie + "]";
	}




	
}
