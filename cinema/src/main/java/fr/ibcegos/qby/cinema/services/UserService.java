package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.User;


public interface UserService {
	//////////
	//CREATE//
	//////////

	/**
	 * Créer un utilisateur
	 * @param user
	 */
	public void create(User user);
	
		
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
}
