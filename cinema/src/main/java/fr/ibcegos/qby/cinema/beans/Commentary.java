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
	private Integer idCommentary;
	
	private Integer rating;
	private String commentary;
	
	@ManyToOne
	private User iduser;
	
	@ManyToOne
	@JoinColumn(name = "idmovie")
	private Movie idmovie;

	public Commentary(Integer rating, String commentary, User iduser, Movie idmovie) {
		super();
		this.rating = rating;
		this.commentary = commentary;
		this.iduser = iduser;
		this.idmovie = idmovie;
	} 
	
	
	
}
