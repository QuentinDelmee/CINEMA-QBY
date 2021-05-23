package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.services.SeatService;

@RestController
public class SeatController {
	
	@Autowired
	private SeatService service;

	//////////
	//CREATE//
	//////////

	//Création d'un siege d'une salle de cinema
	@PostMapping("/REST/siege")
	public Seat createSeat(@RequestBody Seat seat) {
		service.create(seat);
		return seat;
	}

	//////////
	// GET  //
	//////////

	//Récupération par l'id d'un siege d'une salle de cinema
	@GetMapping("/REST/siege/{id}")
	public Seat getFromId(@PathVariable("id") Integer id) {
		return service.getSeatById(id);
	}

	//Récupération de la liste des siege d'une salle de cinema
	@GetMapping("/REST/listeSiege")
	public List<Seat> getAllSeat(){
		return service.getAllSeats();
	}

	//////////
	//UPDATE//
	//////////

	//Mise à jour d'un siege d'une salle de cinema
	@PutMapping("/REST/siege")
	public Seat updateCinemaRoom(@RequestBody Seat seat) {
		service.update(seat);
		return seat;
	}

	//////////
	//DELETE//
	//////////

	//Suppression d'un siege d'une salle de cinema par id
	@DeleteMapping("/REST/siege/{id}")
	public void deleteSeatById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
}
