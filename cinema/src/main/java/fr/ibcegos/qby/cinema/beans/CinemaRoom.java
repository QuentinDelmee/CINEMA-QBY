package fr.ibcegos.qby.cinema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class CinemaRoom {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCinema;
	
	private String roomname;
	private Integer roomlevel;
	private String screensize;
	private Integer nbseats;
	

	@OneToMany(mappedBy="idcinema")
	@JsonBackReference
	private List<Seat> lstSeats = new ArrayList<>();
	
	@OneToMany(mappedBy="idcinema")
	private List<Session> lstSessions = new ArrayList<>();
	
	@OneToMany(mappedBy="idcinema")
	private List<Opinion> lstOpinions = new ArrayList<>();
	
	

	public CinemaRoom(Integer nbseats, String roomname, Integer roomlevel, String screensize) {

		this.nbseats = nbseats;
		this.roomname = roomname;
		this.roomlevel = roomlevel;
		this.screensize = screensize;
		
	}
	
	

//	public void addSeats(Seat seat) {
//		//PLUS TARD Rajouter condition pour vérifier capacité
//		seat.setIdcinema(this);
//		sDao.save(seat);
//		
//	}

	
	
	@Override
	public String toString() {
		return "Cinemas [idCinema=" + idCinema + ", nbseats=" + nbseats + ", roomname=" + roomname
				+ ", roomlevel=" + roomlevel + ", screensize=" + screensize + "]";
	}




	public CinemaRoom(String roomname, Integer roomlevel, String screensize, Integer nbseats) {
		this.roomname = roomname;
		this.roomlevel = roomlevel;
		this.screensize = screensize;
		this.nbseats = nbseats;
	}
	
}
