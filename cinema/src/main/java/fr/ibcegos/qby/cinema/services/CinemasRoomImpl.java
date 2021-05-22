package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.CinemasRoom;
import fr.ibcegos.qby.cinema.beans.Seats;
import fr.ibcegos.qby.cinema.daos.CinemasRoomDAO;
import fr.ibcegos.qby.cinema.daos.SeatsDAO;

@Service
public class CinemasRoomImpl implements CinemasRoomService{
	
	@Autowired
	CinemasRoomDAO dao;
	
	@Autowired
	SeatsDAO daoSeats;
	
	
	@Override
	@Transactional
	public void create(CinemasRoom cinemaRoom) {
		for(Seats seat : cinemaRoom.getLstSeats()) {
			daoSeats.save(seat);
		}
		dao.save(cinemaRoom);
	}

	@Override
	public List<CinemasRoom> getAllCinemasRoom() {
		return (List<CinemasRoom>) dao.findAll();
	}

	@Override
	@Transactional
	public void update(CinemasRoom cinemaRoom) {
		dao.save(cinemaRoom);
	}

	@Override
	@Transactional
	public void delete(CinemasRoom cinemaRoom) {
		dao.delete(cinemaRoom);
	}
}
