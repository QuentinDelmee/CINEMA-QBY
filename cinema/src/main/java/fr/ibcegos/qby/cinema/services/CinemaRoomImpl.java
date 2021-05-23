package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.daos.CinemaRoomDAO;
import fr.ibcegos.qby.cinema.daos.SeatDAO;

@Service
public class CinemaRoomImpl implements CinemaRoomService{
	
	@Autowired
	CinemaRoomDAO dao;
	
	@Autowired
	SeatDAO daoSeats;
	
	
	@Override
	@Transactional
	public void create(CinemaRoom cinemaRoom) {
		for(Seat seat : cinemaRoom.getLstSeats()) {
			daoSeats.save(seat);
		}
		dao.save(cinemaRoom);
	}

	@Override
	public List<CinemaRoom> getAllCinemasRoom() {
		return (List<CinemaRoom>) dao.findAll();
	}

	@Override
	@Transactional
	public void update(CinemaRoom cinemaRoom) {
		dao.save(cinemaRoom);
	}

	@Override
	@Transactional
	public void delete(CinemaRoom cinemaRoom) {
		dao.delete(cinemaRoom);
	}
}
