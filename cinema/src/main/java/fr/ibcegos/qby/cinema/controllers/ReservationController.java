package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.services.ReservationService;

@RestController
public class ReservationController {
	@Autowired
	private ReservationService rservice;

	@PostConstruct
	@Transactional
	public void init() {

	}

	@GetMapping("/REST/reservation/{id}")
	public Reservation getFromId(@PathVariable("id") Integer id) {
		return rservice.getReservation(id);
	}

	@GetMapping("/REST/reservation")
	public List<Reservation> getAll() {
		return rservice.getAllReservation();
	}

	@PostMapping("/REST/reservation")
	public Reservation addAvion(@RequestBody Reservation reservation) {
		rservice.create(reservation);
		return reservation;
	}

	@PutMapping("/REST/reservation")
	public Reservation updateAvion(@RequestBody Reservation reservation) {
		rservice.update(reservation);
		return reservation;
	}
	
	@DeleteMapping("/REST/reservation/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		rservice.deleteById(id);
	}
}
