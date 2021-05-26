package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Person;
import fr.ibcegos.qby.cinema.beans.User;

public interface PersonService {
	
		
	//////////
	//CREATE//
	//////////
	
	/**
	 * Créer une personne
	 * @param person
	 */
	public void create(Person person);
	
		
	//////////
	// GET  //
	//////////
	/**
	 * Récupérer une personne par son id
	 * @param id_person
	 * @return
	 */
	public Person getPersonId(Integer id_person);
	
	/**
	 * Retourne toutes les personnes
	 * @return
	 */
	public List<Person> getAllPerson();
		
	//////////
	//UPDATE//
	//////////
	/**
	 * Modifie  une personne 
	 * @param person
	 */
	
	public void update(Person person);
		
	//////////
	//DELETE//
	//////////
	/**
	 * Supprime  une personne 
	 * @param person
	 */
	public void delete(Person person);
	
	
	/**
	 * Supprime un utilisateur par son id
	 * @param id_user
	 */
	public void deleteById(Integer id_user);
}
