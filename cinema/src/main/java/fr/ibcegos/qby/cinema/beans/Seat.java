package fr.ibcegos.qby.cinema.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
		property = "id_seat")
/**
 * 
 * @author QBY
 *
 */
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_seat;
	
	private Integer seat_number;
	private String row_name;
	private Boolean free;
	
	@ManyToOne
	private CinemaRoom id_cinemaRoom;

	public Seat(Integer seat_number, String row_name, Boolean free) {
		this.seat_number = seat_number;
		this.row_name = row_name;
		this.free = free;
	}

	@Override
	public String toString() {
		return "Seat [id_seat=" + id_seat + ", seat_number=" + seat_number + ", row_name=" + row_name + ", free=" + free
				+ ", id_cinemaRoom=" + id_cinemaRoom + "]";
	}
	

}
