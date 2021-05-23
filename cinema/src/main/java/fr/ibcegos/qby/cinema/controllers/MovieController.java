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

import fr.ibcegos.qby.cinema.beans.Movie;
import fr.ibcegos.qby.cinema.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	//////////
	//CREATE//
	//////////
	
	//Création d'un film
	@PostMapping("/REST/film")
	public Movie createMovie(@RequestBody Movie movie) {
		service.create(movie);
		return movie;
	}
	
	//////////
	// GET  //
	//////////
	
	//Récupération par l'id d'un film
	@GetMapping("/REST/film/{id}")
	public Movie getFromId(@PathVariable("id") Integer id) {
		return service.getMovieById(id);
	}
	
	//Récupération de la liste des films
	@GetMapping("/REST/listesalle")
	public List<Movie> getAllMovies(){
		return service.getAllMovies();
	}
	
	//////////
	//UPDATE//
	//////////
	
	//Mise à jour d'une salle de cinema
	@PutMapping("/REST/movie")
	public Movie updateMovie(@RequestBody Movie movie) {
		service.update(movie);
		return movie;
	}
	
		
	//////////
	//DELETE//
	//////////

	//Suppression d'un film par son id
	@DeleteMapping("/REST/movie/{id}")
	public void deleteMovieById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}


}
