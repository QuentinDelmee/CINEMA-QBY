package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.SecurityLevel;
import fr.ibcegos.qby.cinema.beans.User;

public interface SecurityLevelService {
	//////////
	//CREATE//
	//////////
	
	/**
	 * Créer un niveau de sécurité
	 * @param securityLevel
	 */
	public void create(SecurityLevel  securityLevel);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer un niveau de sécurité par son id
	 * @param idsl
	 * @return
	 */
	public SecurityLevel getSecurityLevelById(Integer idsl);
	
	/**
	 * Retourne tous les niveaux de sécurité
	 * @return
	 */
	public List<SecurityLevel> getAllSecurityLevel();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie un niveau de sécurité
	 * @param user
	 */
	
	public void update(SecurityLevel securityLevel);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime un niveau de sécurité
	 * @param user
	 */
	public void delete(SecurityLevel securityLevel);
	
	
	/**
	 * Supprime un niveau de sécurité par son id
	 * @param iduser
	 */
	public void deleteById(Integer idsl);
	
	
	public List<User> findUserSecurityLevel(Integer idsl) ;
}
