package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "id_Cinema")
/**
 * 
 * @author QBY
 *
 */
public class CinemaRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_Cinema;
	
	
	private Integer nb_seats;
	private String room_name;
	private String room_level;
	private String screen_size;
	
	
	@OneToMany(mappedBy="cinemaRoom")
	private List<Seat> lstSeats = new ArrayList<>();

	public CinemaRoom(Integer nb_seats, String room_name, String room_level, String screen_size) {

		this.nb_seats = nb_seats;
		this.room_name = room_name;
		this.room_level = room_level;
		this.screen_size = screen_size;
		
	}
	
	
	public void addSeats(Seat seat) {
		//PLUS TARD Rajouter condition pour vérifier capacité
		lstSeats.add(seat);
		seat.setCinemaRoom(this);
	}
	
	
	@Override
	public String toString() {
		return "Cinemas [id_Cinema=" + id_Cinema + ", nb_seats=" + nb_seats + ", room_name=" + room_name
				+ ", room_level=" + room_level + ", screen_size=" + screen_size + "]";
	}
	
}
