package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.daos.ReservationDAO;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	UserService uservice ;
	@Autowired
	SeatService sservice ;
	@Autowired
	ReservationDAO rdao ;
	
	@Override
	public void create(Reservation reservation) {
		rdao.save(reservation) ;
	}
	
	@Override
	public Reservation getReservation(Integer id_reservation)
	{	
		return rdao.findById(id_reservation).orElse(null);
	}

	@Override
	public List<Reservation> getAllReservation() {
		return (List<Reservation>) rdao.findAll();
	}

	@Override
	public void update(Reservation reservation) {
		rdao.delete(reservation); 	
	}

	@Override
	public void delete(Reservation reservation) {
		// TODO Auto-generated method stub
		rdao.delete(reservation);
	}

	@Override
	public void deleteById(Integer id_reservation) {
		// TODO Auto-generated method stub
		rdao.deleteById(id_reservation);
	}

}
