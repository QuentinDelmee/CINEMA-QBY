package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemasRoom;
import fr.ibcegos.qby.cinema.beans.Seats;

/**
 * Gestion des places des salles de cinemas
 * @author QBY
 *
 */
public interface SeatsService {

	/**
	 * Créer une salle de cinema
	 * @param cinemaRoom
	 */
	public void create(Seats seat);
	
	/**
	 * Retourne toutes les places de la salle du cinema
	 * @return
	 */
	public List<Seats> getAllSeats();
	
	/**
	 * Modifie la place
	 * @param cinemaRoom
	 */
	public void update(Seats seat);
	
	
	/**
	 * Supprime la place
	 * @param cinemaRoom
	 */
	public void delete(Seats seat);
}
