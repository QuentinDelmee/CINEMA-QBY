package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Seat;

/**
 * Gestion des places des salles de cinemas
 * @author QBY
 *
 */
public interface SeatService {

	//////////
	//CREATE//
	//////////
	/**
	 * Créer une salle de cinema
	 * @param cinemaRoom
	 */
	public void create(Seat seat);
	
		
	//////////
	// GET  //
	//////////

	/**
	 * Récupérer un siege par son Id
	 * @param id_seat
	 * @return
	 */
	public Seat getSeatById(Integer id_seat);
	
	/**
	 * Retourne toutes les places de la salle du cinema
	 * @return
	 */
	public List<Seat> getAllSeats();
	
	
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie la place
	 * @param cinemaRoom
	 */
	public void update(Seat seat);
	
	
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime la place
	 * @param cinemaRoom
	 */
	public void delete(Seat seat);
	
	public void deleteById(Integer id_seat);
}
