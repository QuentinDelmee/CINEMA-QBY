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
 * @author QBY
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Product idProduct;
	@ManyToOne
	@JoinColumn(name = "id")
	private User idUser;
	
	private LocalDateTime date;

	private Integer quantity;
	private Integer idReceipt;
	

	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param idproduct  product which is transacted
	 * @param idusers    user which is buying
	 * @param date        the exact date at which the transaction occurs
	 * @param quantity    the quantity of product which is transacted
	 * @param idpurchase the overall id of the purchases
	 */

	public Purchase(Product idProduct, User idUser, LocalDateTime date, Integer quantity, Integer idReceipt) {
		super();
		this.idProduct = idProduct;
		this.idUser = idUser;
		this.date = date;
		this.quantity = quantity;
		this.idReceipt = idReceipt;
	}



	
	/**
	 * Function which returns a JSON string of the class.
	 */

	
	@Override
	public String toString() {
		return "Purchase [idProduct=" + idProduct + ", idUser=" + idUser + ", date=" + date + ", quantity=" + quantity
				+ ", idReceipt=" + idReceipt + "]";
	}

}
