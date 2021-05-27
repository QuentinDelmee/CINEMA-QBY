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
	public Purchase getPurchase(Integer id_purchase) {
		return pdao.findById(id_purchase).orElse(null);
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

	@Override
	public void deleteById(Integer id_purchase) {
		// TODO Auto-generated method stub
		pdao.deleteById(id_purchase);
	}

	@Override
	public List<Purchase> getByReceipt(Integer id_receipt) {
		// TODO Auto-generated method stub
		return (List<Purchase>) pdao.findByIdReceipt(id_receipt);
	}

	@Override
	public void deleteByReceipt(Integer id_receipt) {
		// TODO Auto-generated method stub
		pdao.deleteByIdReceipt(id_receipt);
	}

}
