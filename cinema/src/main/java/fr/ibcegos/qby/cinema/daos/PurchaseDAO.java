package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Purchase;

/**
 * Interface DAO to manage Purchase DataBase
 * 
 * @author QBY
 *
 */
public interface PurchaseDAO extends CrudRepository<Purchase, Integer> {

//	/**
//	 * Function to get all purchase with same id in DB
//	 * 
//	 * @param id_purchase the id of the bill purchases from a user.
//	 * @return a list of all purchase from a user at an instant t
//	 */
//	public List<Purchase> findByIdReceipt(Integer id_receipt);
//
//	/**
//	 * Function to delete all purchase from same id in DB
//	 * 
//	 * @param id_purchase the id of the bill purchases from a user.
//	 */
//	public void deleteByIdReceipt(Integer id_receipt);
}
