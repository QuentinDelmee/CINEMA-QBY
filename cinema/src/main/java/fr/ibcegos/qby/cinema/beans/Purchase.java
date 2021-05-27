package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Class which allows to stock and manage all purchases from users
 * 
 * @author ib
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idpurchase;
	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Product idproduct;
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User iduser;
	private LocalDateTime date;

	private Integer quantity;
	private Integer idreceipt;

	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param idproduct  product which is transacted
	 * @param idusers    user which is buying
	 * @param date        the exact date at which the transaction occurs
	 * @param quantity    the quantity of product which is transacted
	 * @param idpurchase the overall id of the purchases
	 */
	public Purchase(Product idproduct, User iduser, LocalDateTime date, Integer quantity, Integer idreceipt) {
		super();
		this.idproduct = idproduct;
		this.iduser = iduser;
		this.date = date;
		this.quantity = quantity;
		this.idreceipt = idreceipt;
	}
	
	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Purchase [idpurchase=" + idpurchase + ", idproduct=" + idproduct + ", iduser=" + iduser
				+ ", date=" + date + ", quantity=" + quantity + ", idreceipt=" + idreceipt + "]";
	}
	
	

}
