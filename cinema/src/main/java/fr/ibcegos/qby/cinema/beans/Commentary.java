package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Entity;
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
	private Integer rating;
	private String commentary;
	
	//Plusieurs film peuvent avoir plusieurs commentaires
	@ManyToMany
	private Movie movie_id;
	
	//Plusieurs film peuvent avoir plusieurs commentaires
	@ManyToMany
	private User user_id;
	
	
}
