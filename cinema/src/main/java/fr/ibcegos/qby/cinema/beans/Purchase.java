package fr.ibcegos.qby.cinema.beans;

import java.sql.Date;
import java.time.LocalDateTime;

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
	private Product id_product;
	@Id
	private User id_users;
	@Id
	private LocalDateTime date;

	private Integer quantity;
	private Integer id_purchase;
	
	public Purchase(Product id_product, User id_users, LocalDateTime date, Integer quantity, Integer id_purchase) {
		super();
		this.id_product = id_product;
		this.id_users = id_users;
		this.date = date;
		this.quantity = quantity;
		this.id_purchase = id_purchase;
	}

	@Override
	public String toString() {
		return "Purchases [id=" + id_purchase + ", id_product=" + id_product + ", id_users=" + id_users + ", date="
				+ date + ", quantity=" + quantity + "]";
	}



}
