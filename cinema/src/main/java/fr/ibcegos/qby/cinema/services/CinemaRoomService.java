package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;

/**
 * Gestion des salles de cinemas
 * @author QBY
 *
 */
public interface CinemaRoomService {
	
	/**
	 * Créer une salle de cinema
	 * @param cinemaRoom
	 */
	public void create(CinemaRoom cinemaRoom);
	
	/**
	 * Retourne toutes les salles du cinema
	 * @return
	 */
	public List<CinemaRoom> getAllCinemasRoom();
	
	/**
	 * Modifie la salle d'un cinema
	 * @param cinemaRoom
	 */
	public void update(CinemaRoom cinemaRoom);
	
	
	/**
	 * Supprime la salle de cinema
	 * @param cinemaRoom
	 */
	public void delete(CinemaRoom cinemaRoom);
}
