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
import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.services.CommentaryService;

@RestController
public class CommentaryController {

	@Autowired
	private CommentaryService service;
	
	//////////
	//CREATE//
	//////////
	
	//Création d'un commentaire
	@PostMapping("/REST/commentaire")
	public Commentary createCommentary(@RequestBody Commentary commentary) {
		service.create(commentary);
		return commentary;
	}
	
	//////////
	// GET  //
	//////////
	
	//Récupération par l'id d'un commentaire
	@GetMapping("/REST/commentaire/{id}")
	public Commentary getFromId(@PathVariable("id") Integer id) {
		return service.getCommentaryById(id);
	}
	
	//Récupération de la liste des commentaires
	@GetMapping("/REST/listecommentaire")
	public List<Commentary> getAllCommentary(){
		return service.getAllCommentary();
	}
	
	//////////
	//UPDATE//
	//////////
	
	//Mise à jour d'un commentaire
	@PutMapping("/REST/commentaire")
	public Commentary updateCinemaRoom(@RequestBody Commentary commentary) {
		service.update(commentary);
		return commentary;
	}
	
		
	//////////
	//DELETE//
	//////////
	
	//Suppression commentaire par id
	@DeleteMapping("/REST/commentaire/{id}")
	public void deleteCommentaireById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
	
}
