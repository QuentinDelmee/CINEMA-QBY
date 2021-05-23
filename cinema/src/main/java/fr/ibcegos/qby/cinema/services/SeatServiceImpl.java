package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.daos.SeatDAO;

@Service
public class SeatServiceImpl implements SeatService{
	
	@Autowired
	SeatDAO dao;
	
	//////////
	//CREATE//
	//////////
	@Override
	@Transactional
	public void create(Seat seat) {
		dao.save(seat);
	}

	//////////
	// GET  //
	//////////
	@Override
	public Seat getSeatById(Integer id_seat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Seat> getAllSeats() {
		return (List<Seat>) dao.findAll();
	}

	//////////
	//UPDATE//
	//////////
	@Override
	@Transactional
	public void update(Seat seat) {
		dao.save(seat);
	}

	
	//////////
	//DELETE//
	//////////
	@Override
	@Transactional
	public void delete(Seat seat) {
		dao.delete(seat);
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id_seat) {
		// TODO Auto-generated method stub
		
	}

}
