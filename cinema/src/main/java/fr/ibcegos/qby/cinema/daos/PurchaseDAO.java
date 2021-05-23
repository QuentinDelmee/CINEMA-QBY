package fr.ibcegos.qby.cinema.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Purchase;

public interface PurchaseDAO extends CrudRepository<Purchase, Integer> {
	public List<Purchase> findByIdPurchase(Integer id_purchase);

	public void deleteByIdPurchase(Integer id_purchase);
}
