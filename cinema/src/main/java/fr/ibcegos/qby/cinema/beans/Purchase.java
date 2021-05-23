package fr.ibcegos.qby.cinema.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_purchase;
	private Product id_product;
	private User id_users;
	private Date date;
	private Integer quantity;

	public Purchase(Product id_product, User id_users, Date date, Integer quantity) {
		super();
		this.id_product = id_product;
		this.id_users = id_users;
		this.date = date;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Purchases [id=" + id_purchase + ", id_product=" + id_product + ", id_users="
				+ id_users + ", date=" + date + ", quantity=" + quantity + "]";
	}

}
