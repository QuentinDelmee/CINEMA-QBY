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
import fr.ibcegos.qby.cinema.services.CinemaRoomService;

@RestController
public class CinemaRoomController {

	@Autowired
	private CinemaRoomService crservice;
	

	//////////
	//CREATE//
	//////////
	
	//Création d'une salle de cinema
	@PostMapping("/REST/cinemaroom")
	public CinemaRoom createCinemaRoom(@RequestBody CinemaRoom cinema) {
		crservice.create(cinema);
		return cinema;
	}
	
	//////////
	// GET  //
	//////////
	
	//Récupération par l'id d'une salle du cinema
	@GetMapping("/REST/cinemaroom/{id}")
	public CinemaRoom getFromId(@PathVariable("id") Integer id) {
		return crservice.getCinemaRoomById(id);
	}
	
	//Récupération de la liste des salles du cinema
	@GetMapping("/REST/cinemaroom")
	public List<CinemaRoom> getAllCinemasRoom(){
		return crservice.getAllCinemasRoom();
	}
	
	//////////
	//UPDATE//
	//////////
	
	//Mise à jour d'une salle de cinema
	@PutMapping("/REST/cinemaroom")
	public CinemaRoom updateCinemaRoom(@RequestBody CinemaRoom cinema) {
		crservice.update(cinema);
		return cinema;
	}
	
		
	//////////
	//DELETE//
	//////////
	
	//Suppression cinema par id
	@DeleteMapping("/REST/cinemaroom/{id}")
	public void deleteCinemaRoomById(@PathVariable("id") Integer id) {
		crservice.deleteById(id);
	}
	
}
