package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Purchase;

public interface PurchaseService {
	public void create(Purchase cinemaRoom);

	public List<Purchase> getPurchase(Integer id_purchase);

	public List<Purchase> getAllPurchase();

	public void update(Purchase cinemaRoom);

	public void delete(Purchase cinemaRoom);
}
