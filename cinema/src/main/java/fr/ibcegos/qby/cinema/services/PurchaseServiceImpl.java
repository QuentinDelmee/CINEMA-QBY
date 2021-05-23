package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Purchase;
import fr.ibcegos.qby.cinema.daos.PurchaseDAO;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	UserService uservice;
	@Autowired
	ProductService pservice;
	@Autowired
	PurchaseDAO pdao;

	@Override
	public void create(Purchase purchase) {
		pdao.save(purchase);
	}

	@Override
	public List<Purchase> getPurchase(Integer id_purchase) {
		return (List<Purchase>) pdao.findByIdPurchase(id_purchase);
	}

	@Override
	public List<Purchase> getAllPurchase() {
		return (List<Purchase>) pdao.findAll();
	}

	@Override
	public void update(Purchase purchase) {
		pdao.save(purchase);

	}

	@Override
	public void delete(Purchase purchase) {
		pdao.delete(purchase);

	}

}
