package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	private Integer id_Commentary;
	
	private Integer rating;
	private String commentary;
	
	//Plusieurs film peuvent avoir plusieurs commentaires
	//@ManyToMany
	private Movie movie_id;
	
	//Plusieurs film peuvent avoir plusieurs commentaires
	//@ManyToMany
	private User user_id;
	
	
}
