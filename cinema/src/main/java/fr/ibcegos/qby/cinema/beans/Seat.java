package fr.ibcegos.qby.cinema.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
	@JoinColumn(name = "id_cinema", referencedColumnName = "id")
	private CinemaRoom idCinema;

	public Seat(Integer seatNumber, String rowName, Boolean free, CinemaRoom idCinema) {
		super();
		this.seatNumber = seatNumber;
		this.rowName = rowName;
		this.free = free;
		this.idCinema = idCinema;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatNumber=" + seatNumber + ", rowName=" + rowName + ", free=" + free
				+ ", idCinema=" + idCinema.getId() + "]";
	}

}
