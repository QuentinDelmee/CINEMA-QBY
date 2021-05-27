package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Commentary;

public interface CommentaryService {

	/**
	 * Gestion des commentaires de films
	 * @author QBY
	 *
	 */
	
	//////////
	//CREATE//
	//////////
	/**
	 * Créer un commentaire de film
	 * @param commentary
	 */
	public void create(Commentary commentary);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer un commentaire de film par son ID
	 * @param id_Commentary
	 * @return
	 */
	public Commentary getCommentaryById(Integer id_Commentary);
	
	/**
	 * Retourne tous les commentaires d'un film
	 * @return
	 */
	public List<Commentary> getAllCommentary();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie le commentaire d'un film
	 * @param commentary
	 */
	public void update(Commentary commentary);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime le commentaire d'un film
	 * @param commentary
	 */
	public void delete(Commentary commentary);
	
	
	/**
	 * Supprime le commentaire d'un film par son ID
	 * @param id_Commentary
	 */
	public void deleteById(Integer id_Commentary);
}
