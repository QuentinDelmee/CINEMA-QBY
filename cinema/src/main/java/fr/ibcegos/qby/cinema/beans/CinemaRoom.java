package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import fr.ibcegos.qby.cinema.daos.SeatDAO;
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
public class CinemaRoom {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_Cinema;
	
	private String room_name;
	private Integer room_level;
	private String screen_size;
	private Integer nb_seats;
	

	@OneToMany(mappedBy="id_cinema")
	@JsonBackReference
	private List<Seat> lstSeats = new ArrayList<>();
	
	@OneToMany(mappedBy="id_cinema")
	private List<Session> lstSessions = new ArrayList<>();
	
	@OneToMany(mappedBy="id_cinema")
	private List<Opinion> lstOpinions = new ArrayList<>();
	
	

	public CinemaRoom(Integer nb_seats, String room_name, Integer room_level, String screen_size) {

		this.nb_seats = nb_seats;
		this.room_name = room_name;
		this.room_level = room_level;
		this.screen_size = screen_size;
		
	}
	
	
<<<<<<< HEAD
//	public void addSeats(Seat seat) {
//		//PLUS TARD Rajouter condition pour vérifier capacité
//		seat.setId_cinema(this);
//		sDao.save(seat);
//		
//	}
=======
	
	
	public void addSeats(Seat seat) {
		//PLUS TARD Rajouter condition pour vérifier capacité
		lstSeats.add(seat);
		seat.setId_cinema(this);
	}
>>>>>>> d4a8400725edda485e1766fe2683494da62ecf51
	
	
	@Override
	public String toString() {
		return "Cinemas [id_Cinema=" + id_Cinema + ", nb_seats=" + nb_seats + ", room_name=" + room_name
				+ ", room_level=" + room_level + ", screen_size=" + screen_size + "]";
	}




	public CinemaRoom(String room_name, Integer room_level, String screen_size, Integer nb_seats) {
		this.room_name = room_name;
		this.room_level = room_level;
		this.screen_size = screen_size;
		this.nb_seats = nb_seats;
	}
	
}
