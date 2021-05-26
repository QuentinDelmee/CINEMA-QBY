package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Security_Level;

public interface Security_LevelService {
	//////////
	//CREATE//
	//////////
	
	/**
	 * Créer un niveau de sécurité
	 * @param securityLevel
	 */
	public void create(Security_Level  securityLevel);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer un niveau de sécurité par son id
	 * @param id_sl
	 * @return
	 */
	public Security_Level getSecurityLevelById(Integer id_sl);
	
	/**
	 * Retourne tous les niveaux de sécurité
	 * @return
	 */
	public List<Security_Level> getAllSecurityLevel();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie un niveau de sécurité
	 * @param user
	 */
	
	public void update(Security_Level securityLevel);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime un niveau de sécurité
	 * @param user
	 */
	public void delete(Security_Level securityLevel);
	
	
	/**
	 * Supprime un niveau de sécurité par son id
	 * @param id_user
	 */
	public void deleteById(Integer id_sl);
}
