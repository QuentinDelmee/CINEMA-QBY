package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Purchase;

public interface PurchaseDAO extends CrudRepository<Purchase, Integer>{

}
