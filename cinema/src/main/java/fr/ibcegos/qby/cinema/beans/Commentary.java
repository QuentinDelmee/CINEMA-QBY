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
	
	public Commentary filter(Commentary comment) {
		String commentary = comment.commentary;
		
			//Dictionnaire de gros mots
			String[] myList2 = {"shit","fuck","vilain","chier","merde"};
			
			for(String insult:myList2) {
				
				if(commentary.contains(insult)) {
					
					String replace = "";
					for(int i = 0; i< insult.length(); i++) {
						replace += "*";
					}
					commentary = commentary.replace(insult, replace);
				}
			}
			comment.commentary = commentary;
			return comment;
		}

}
