package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Purchase;

/**
 * 
 * Interface Service for the Purchase Class/Entity
 * 
 * @author QBY
 *
 */
public interface PurchaseService {

	/**
	 * Function to create an purchase in DB
	 * 
	 * @param purchase the purchase to add in DB
	 */
	public void create(Purchase purchase);

	/**
	 * Function to obtain an purchase with specific id
	 * 
	 * @param id_purchase the id of the purchase searched
	 * @return Purchase from DB
	 */
	public Purchase getPurchase(Integer id_purchase);

	/**
	 * Function to obtain all purchase
	 * 
	 * @return a list of all purchases
	 */
	public List<Purchase> getAllPurchase();

	/**
	 * Function to update a purchase
	 * 
	 * @param purchase the purchase we want to update
	 */
	public void update(Purchase purchase);

	/**
	 * Function to delete a purchase
	 * 
	 * @param purchase the purchase we want to delete
	 */
	public void delete(Purchase purchase);

	/**
	 * Function to delete a purchase with its id
	 * 
	 * @param id_purchase the id of the purchase we want to delete
	 */
	public void deleteById(Integer id_purchase);
	
//	public List<Purchase> getByReceipt(Integer id_receipt);
//	public void deleteByReceipt(Integer id_receipt);
}
