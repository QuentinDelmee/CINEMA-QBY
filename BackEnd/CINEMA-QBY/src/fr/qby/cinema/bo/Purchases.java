package fr.qby.cinema.bo;

import java.sql.Date;

public class Purchases {
	private Products id_product ;
	private Users id_users ;
	private Date date ;
	private int quantity ;
	private int id_purchase ;
	
	public Purchases(Products id_product, Users id_users, Date date, int quantity, int id_purchase) {
		this.id_product = id_product;
		this.id_users = id_users;
		this.date = date;
		this.quantity = quantity;
		this.id_purchase = id_purchase;
	}

	public Products getId_product() {
		return id_product;
	}

	public void setId_product(Products id_product) {
		this.id_product = id_product;
	}

	public Users getId_users() {
		return id_users;
	}

	public void setId_users(Users id_users) {
		this.id_users = id_users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId_purchase() {
		return id_purchase;
	}

	public void setId_purchase(int id_purchase) {
		this.id_purchase = id_purchase;
	}

	@Override
	public String toString() {
		return "Purchases [id_product=" + id_product + ", id_users=" + id_users + ", date=" + date + ", quantity="
				+ quantity + ", id_purchase=" + id_purchase + "]";
	}
	
	
	
	
	
}
