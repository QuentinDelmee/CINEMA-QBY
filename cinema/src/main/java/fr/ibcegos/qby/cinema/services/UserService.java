package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.Purchase;
import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.User;


public interface UserService {
	//////////
	//CREATE//
	//////////

	/**
	 * Créer un utilisateur
	 * @param user
	 * @return 
	 */
	public User create(User user);
	public Integer createVerif(User user);
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer un utilisateur par son id
	 * @param id_user
	 * @return
	 */
	public User getUserId(Integer id_user);
	
	/**
	 * Retourne toutes les utilisateurs
	 * @return
	 */
	public List<User> getAllUser();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie un utilisateur
	 * @param user
	 */
	
	public void update(User user);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime un utilisateur
	 * @param user
	 */
	public void delete(User user);
	
	
	/**
	 * Supprime un utilisateur par son id
	 * @param id_user
	 */
	public void deleteById(Integer id_user);


	public boolean login(User user);
	
	public List<Opinion> findOpinionUser(Integer id_user);
	public List<Commentary> findCommentaryUser(Integer id_user);
	public List<Purchase> findPurchaseUser(Integer id_user);
	public List<Reservation> findReservationUser(Integer id_user);
}
