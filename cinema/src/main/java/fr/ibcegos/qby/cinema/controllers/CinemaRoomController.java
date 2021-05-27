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

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.services.CinemaRoomService;

@RestController
public class CinemaRoomController {

	@Autowired
	private CinemaRoomService service;
	

	//////////
	//CREATE//
	//////////
	
	//Création d'une salle de cinema
	@PostMapping("/REST/salle")
	public CinemaRoom createCinemaRoom(@RequestBody CinemaRoom cinema) {
		service.create(cinema);
		return cinema;
	}
	
	//////////
	// GET  //
	//////////
	
	//Récupération par l'id d'une salle du cinema
	@GetMapping("/REST/salle/{id}")
	public CinemaRoom getFromId(@PathVariable("id") Integer id) {
		return service.getCinemaRoomById(id);
	}
	
	//Récupération de la liste des salles du cinema
	@GetMapping("/REST/listesalle")
	public List<CinemaRoom> getAllCinemasRoom(){
		return service.getAllCinemasRoom();
	}
	
	//////////
	//UPDATE//
	//////////
	
	//Mise à jour d'une salle de cinema
	@PutMapping("/REST/salle")
	public CinemaRoom updateCinemaRoom(@RequestBody CinemaRoom cinema) {
		service.update(cinema);
		return cinema;
	}
	
		
	//////////
	//DELETE//
	//////////
	
	//Suppression cinema par id
	@DeleteMapping("/REST/salle/{id}")
	public void deleteCinemaRoomById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
	
}
