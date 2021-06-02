package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.daos.CinemaRoomDAO;
import fr.ibcegos.qby.cinema.daos.SeatDAO;

@Service
public class CinemaRoomImpl implements CinemaRoomService{
	
	@Autowired
	CinemaRoomDAO dao;
	
	@Autowired
	SeatDAO daoSeats;
	
	//////////
	//CREATE//
	//////////
	@Override
	@Transactional
	public void create(CinemaRoom cinemaRoom) {
		dao.save(cinemaRoom);
	}

	
	
	//////////
	// GET  //
	//////////
	@Override
	public CinemaRoom getCinemaRoomById(Integer id_Cinema) {
		return dao.findById(id_Cinema).orElse(null);
	}
	
	@Override
	public List<CinemaRoom> getAllCinemasRoom() {
		return (List<CinemaRoom>) dao.findAll();
	}

	
	//////////
	//UPDATE//
	//////////
	@Override
	@Transactional
	public void update(CinemaRoom cinemaRoom) {
		dao.save(cinemaRoom);
	}

	
	//////////
	//DELETE//
	//////////
	@Override
	@Transactional
	public void delete(CinemaRoom cinemaRoom) {
		dao.delete(cinemaRoom);
	}


	@Override
	@Transactional
	public void deleteById(Integer id_Cinema) {
		dao.deleteById(id_Cinema);
	}



	@Override
	public List<Seat> getSeatCinemaRoom(Integer id_Cinema) {
		// TODO Auto-generated method stub
		return dao.findById(id_Cinema).orElse(new CinemaRoom()).getLstSeats() ;
	}



	@Override
	public List<Opinion> getOpinionCinemaRoom(Integer id_Cinema) {
		// TODO Auto-generated method stub
		return dao.findById(id_Cinema).orElse(new CinemaRoom()).getLstOpinions() ;
	}
}
