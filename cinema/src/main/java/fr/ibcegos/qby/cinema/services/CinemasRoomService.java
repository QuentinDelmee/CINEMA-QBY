package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemasRoom;

/**
 * Gestion des salles de cinemas
 * @author QBY
 *
 */
public interface CinemasRoomService {
	
	/**
	 * Créer une salle de cinema
	 * @param cinemaRoom
	 */
	public void create(CinemasRoom cinemaRoom);
	
	/**
	 * Retourne toutes les salles du cinema
	 * @return
	 */
	public List<CinemasRoom> getAllCinemasRoom();
	
	/**
	 * Modifie la salle d'un cinema
	 * @param cinemaRoom
	 */
	public void update(CinemasRoom cinemaRoom);
	
	
	/**
	 * Supprime la salle de cinema
	 * @param cinemaRoom
	 */
	public void delete(CinemasRoom cinemaRoom);
}
