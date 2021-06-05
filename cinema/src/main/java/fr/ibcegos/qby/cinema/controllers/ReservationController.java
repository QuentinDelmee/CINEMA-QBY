package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.services.ReservationService;
import fr.ibcegos.qby.cinema.services.UserService;

/**
 * Controller class for Reservation with basic CRUDs Mapping
 * @author QBY
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class ReservationController {
	@Autowired
	private ReservationService rservice;
	@Autowired 
	private UserService uservice ;

	/**
	 * Initialization function to potentially add data in DB
	 */
	@PostConstruct
	@Transactional
	public void init() {

	}

	/**
	 * Function to Map getReservation to an URL
	 * 
	 * @param id the id of the reservation we want to get
	 * @return the reservation found in the DB (null if absent)
	 */
	@GetMapping("/REST/reservation/{id}")
	public Reservation getFromId(@PathVariable("id") Integer id) {
		return rservice.getReservation(id);
	}
	/**
	 * Function to Map getAllReservation to an URL
	 * 
	 * @return the list of all reservation in DB
	 */
	@GetMapping("/REST/reservation")
	public List<Reservation> getAll() {
		return rservice.getAllReservation();
	}
	
	@GetMapping("/REST/reservation/user")
	public List<Reservation> getUserReservation(@PathVariable Integer id) {
		User idUser = uservice.getUserId(id);
		return rservice.getUserReservation(idUser);
	}

	/**
	 * Function to Map POST create to an URL
	 * 
	 * @param purchase the reservation posted inside a form
	 * @return the reservation object we obtain
	 */
	@PostMapping("/REST/reservation")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		rservice.create(reservation);
		return reservation;
	}
	/**
	 * Function to map PUT update to an URL
	 * 
	 * @param reservation the reservation to update
	 * @return the updated reservation we obtain
	 */
	@PutMapping("/REST/reservation")
	public Reservation updateReservation(@RequestBody Reservation reservation) {
		rservice.update(reservation);
		return reservation;
	}
	/**
	 * Function to Map DELETE deleteById to an URL
	 * 
	 * @param id the id of the reservation to delete
	 */
	@DeleteMapping("/REST/reservation/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		rservice.deleteById(id);
	}
}
