package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private Product id_product;
	@Id
	private User id_users;
	@Id
	private LocalDateTime date;

	private Integer quantity;
	private Integer id_purchase;

	/**
	 * Constructor of the class, all other function are automated with Lombok
	 * 
	 * @param id_product  product which is transacted
	 * @param id_users    user which is buying
	 * @param date        the exact date at which the transaction occurs
	 * @param quantity    the quantity of product which is transacted
	 * @param id_purchase the overall id of the purchases
	 */
	public Purchase(Product id_product, User id_users, LocalDateTime date, Integer quantity, Integer id_purchase) {
		super();
		this.id_product = id_product;
		this.id_users = id_users;
		this.date = date;
		this.quantity = quantity;
		this.id_purchase = id_purchase;
	}

	/**
	 * Function which returns a JSON string of the class.
	 */
	@Override
	public String toString() {
		return "Purchases [id=" + id_purchase + ", id_product=" + id_product + ", id_users=" + id_users + ", date="
				+ date + ", quantity=" + quantity + "]";
	}

}
