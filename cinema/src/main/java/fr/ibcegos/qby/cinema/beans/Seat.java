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
	private Integer idseat;
	
	private Integer seatnumber;
	private String rowname;
	private Boolean free;
	
	@ManyToOne
	private CinemaRoom idcinema;
	
	@OneToMany(mappedBy="idreservation")
	private List<Reservation> allReservations;

	public Seat(Integer seatnumber, String rowname, Boolean free) {
		this.seatnumber = seatnumber;
		this.rowname = rowname;
		this.free = free;
	}

	@Override
	public String toString() {
		return "Seat [idseat=" + idseat + ", seatnumber=" + seatnumber + ", rowname=" + rowname + ", free=" + free
				+ ", idcinema=" + idcinema + "]";
	}
	

}
