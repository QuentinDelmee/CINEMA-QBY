package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Reservation;

/**
 * 
 * Interface Service for the Reservation Class/Entity
 * 
 * @author QBY
 *
 */
public interface ReservationService {

	/**
	 * Function to create an reservation in DB
	 * 
	 * @param reservation the reservation to add in DB
	 */
	public void create(Reservation reservation);

	/**
	 * Function to obtain an reservation with specific id
	 * 
	 * @param id_reservation the id of the reservation searched
	 * @return Reservation from DB
	 */
	public Reservation getReservation(Integer id_reservation);

	/**
	 * Function to obtain all reservation
	 * 
	 * @return a list of all reservations
	 */
	public List<Reservation> getAllReservation();

	/**
	 * Function to update a reservation
	 * 
	 * @param reservation the reservation we want to update
	 */
	public void update(Reservation reservation);

	/**
	 * Function to delete a reservation
	 * 
	 * @param reservation the reservation we want to delete
	 */
	public void delete(Reservation reservation);

	/**
	 * Function to delete a reservation with its id
	 * 
	 * @param id_reservation the id of the reservation we want to delete
	 */
	public void deleteById(Integer id_reservation);
}
