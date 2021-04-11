package fr.qby.cinema.bo;

import java.sql.Date;

public class Achat {
	private int id_achat ;
	private Produits id_produits ;
	private Utilisateurs id_users ;
	private Date date ;
	private int quantité ;
	
	public Achat(int id_achat, Produits id_produits, Utilisateurs id_users, Date date, int quantité) {
		this.id_achat = id_achat;
		this.id_produits = id_produits;
		this.id_users = id_users;
		this.date = date;
		this.quantité = quantité;
	}

	public int getId_achat() {
		return id_achat;
	}

	public void setId_achat(int id_achat) {
		this.id_achat = id_achat;
	}

	public Produits getId_produits() {
		return id_produits;
	}

	public void setId_produits(Produits id_produits) {
		this.id_produits = id_produits;
	}

	public Utilisateurs getId_users() {
		return id_users;
	}

	public void setId_users(Utilisateurs id_users) {
		this.id_users = id_users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	
	
	
}
