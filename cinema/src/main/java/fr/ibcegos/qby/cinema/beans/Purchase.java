package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	@JoinColumn(name = "id_product")
	private Product idProduct;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User idUser;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime idDate;

	private Integer quantity;
	private Integer idReceipt;

	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param idproduct  product which is transacted
	 * @param idusers    user which is buying
	 * @param date       the exact date at which the transaction occurs
	 * @param quantity   the quantity of product which is transacted
	 * @param idpurchase the overall id of the purchases
	 */

	public Purchase(Product idProduct, User idUser, LocalDateTime date, Integer quantity, Integer idReceipt) {
		super();
		this.idProduct = idProduct;
		this.idUser = idUser;
		this.idDate = date;
		this.quantity = quantity;
		this.idReceipt = idReceipt;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", idProduct=" + idProduct.getId() + ", idUser=" + idUser.getId() + ", date="
				+ idDate + ", quantity=" + quantity + ", idReceipt=" + idReceipt + "]";
	}

}