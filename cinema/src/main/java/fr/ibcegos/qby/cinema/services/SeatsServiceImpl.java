package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Seats;
import fr.ibcegos.qby.cinema.daos.SeatsDAO;

@Service
public class SeatsServiceImpl implements SeatsService{
	
	@Autowired
	SeatsDAO dao;
	
	@Override
	@Transactional
	public void create(Seats seat) {
		dao.save(seat);
	}

	@Override
	public List<Seats> getAllSeats() {
		return (List<Seats>) dao.findAll();
	}

	@Override
	@Transactional
	public void update(Seats seat) {
		dao.save(seat);
	}

	@Override
	@Transactional
	public void delete(Seats seat) {
		dao.delete(seat);
	}

}
