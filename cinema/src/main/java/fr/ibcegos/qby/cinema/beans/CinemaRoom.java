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
	private Integer id;
	
	private String roomName;
	private Integer roomLevel;
	private String screenSize;
	private Integer nbSeats;
	

	@OneToMany(targetEntity=Seat.class,mappedBy="id")
	private List<Seat> lstSeats = new ArrayList<>();
	
	@OneToMany(targetEntity=Session.class, mappedBy="id")
	private List<Session> lstSessions = new ArrayList<>();
	
	@OneToMany(targetEntity=Opinion.class, mappedBy="id")
	private List<Opinion> lstOpinions = new ArrayList<>();
	
	
	public CinemaRoom(String roomName, Integer roomLevel, String screenSize,Integer nbSeats) {

		this.nbSeats = nbSeats;
		this.roomName = roomName;
		this.roomLevel = roomLevel;
		this.screenSize = screenSize;
		
	}


	@Override
	public String toString() {
		return "CinemaRoom [roomName=" + roomName + ", roomLevel=" + roomLevel + ", screenSize=" + screenSize
				+ ", nbSeats=" + nbSeats + "]";
	}



}
