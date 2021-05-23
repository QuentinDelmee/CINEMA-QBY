package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Reservation;

public interface ReservationService {
	public void create(Reservation cinemaRoom);

	public Reservation getReservation(Integer id_reservation);

	public List<Reservation> getAllReservation();

	public void update(Reservation cinemaRoom);

	public void delete(Reservation cinemaRoom);
}
