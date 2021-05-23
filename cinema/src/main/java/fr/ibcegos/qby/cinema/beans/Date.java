package fr.ibcegos.qby.cinema.beans;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Date {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_date;
	
	private LocalDateTime date;
	
	//Association vers table reservation
	@OneToMany(mappedBy="reservation_date")
	private List<Reservation> lstReservation_date = new ArrayList<>();
	
	//Association vers table session
	@OneToMany(mappedBy="session_date")
	private List<Session> lstSession_date = new ArrayList<>();
	
	//Association vers table purchase
	@OneToMany(mappedBy="purchase_date")
	private List<Purchase> lstPurchase_date = new ArrayList<>();

	@Override
	public String toString() {
		return "Date [id_date=" + id_date + ", date=" + date + ", lstReservation_date=" + lstReservation_date
				+ ", lstSession_date=" + lstSession_date + ", lstPurchase_date=" + lstPurchase_date + "]";
	}
	
}
