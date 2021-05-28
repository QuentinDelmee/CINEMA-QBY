package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Movie;

/**
 * Gestion des films du cinema
 * @author QBY
 *
 */
public interface MovieService {
	
	//////////
	//CREATE//
	//////////
	/**
	 * Créer un film
	 * @param movie
	 */
	public void create(Movie movie);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer un film par son ID
	 * @param id_Movie
	 * @return
	 */
	public Movie getMovieById(Integer id_Movie);
	
	/**
	 * Retourne tous les films du cinema
	 * @return
	 */
	public List<Movie> getAllMovies();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie le film
	 * @param movie
	 */
	public void update(Movie movie);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime le film du cinema
	 * @param movie
	 */
	public void delete(Movie movie);
	
	
	/**
	 * Supprime un film du cinema par son ID
	 * @param id_Movie
	 */
	public void deleteById(Integer id_Movie);
}
