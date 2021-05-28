package fr.ibcegos.qby.cinema.beans;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer seatNumber;
	private String rowName;
	private Boolean free;
	
	@ManyToOne
	private CinemaRoom idCinema;
	
	@OneToMany(mappedBy="id")
	private List<Reservation> allReservations;

	public Seat(Integer seatNumber, String rowName, Boolean free, CinemaRoom idCinema) {
		super();
		this.seatNumber = seatNumber;
		this.rowName = rowName;
		this.free = free;
		this.idCinema = idCinema;
	}

	@Override
	public String toString() {
		return "Seat [seatNumber=" + seatNumber + ", rowName=" + rowName + ", free=" + free + ", idCinema=" + idCinema
				+ "]";
	}

	

}
