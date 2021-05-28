package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;

/**
 * Gestion des salles de cinemas
 * @author QBY
 *
 */
public interface CinemaRoomService {
	
	//////////
	//CREATE//
	//////////
	/**
	 * Créer une salle de cinema
	 * @param cinemaRoom
	 */
	public void create(CinemaRoom cinemaRoom);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer une salle de cinema par son ID
	 * @param id_Cinema
	 * @return
	 */
	public CinemaRoom getCinemaRoomById(Integer id_Cinema);
	
	/**
	 * Retourne toutes les salles du cinema
	 * @return
	 */
	public List<CinemaRoom> getAllCinemasRoom();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie la salle d'un cinema
	 * @param cinemaRoom
	 */
	public void update(CinemaRoom cinemaRoom);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime la salle de cinema
	 * @param cinemaRoom
	 */
	public void delete(CinemaRoom cinemaRoom);
	
	
	/**
	 * Supprime une salle de cinema par son ID
	 * @param id_Cinema
	 */
	public void deleteById(Integer id_Cinema);
}
