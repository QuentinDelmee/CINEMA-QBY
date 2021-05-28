package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Opinion;

/**
 * 
 * Interface Service for the Opinion Class/Entity
 * 
 * @author QBY
 *
 */
public interface OpinionService {

	/**
	 * Function to create an opinion in DB
	 * 
	 * @param opinion the opinion to add in DB
	 */
	public void create(Opinion opinion);

	/**
	 * Function to obtain an opinion with specific id
	 * 
	 * @param id_opinion the id of the opinion searched
	 * @return Opinion from DB
	 */
	public Opinion getOpinion(Integer id_opinion);

	/**
	 * Function to obtain all opinion
	 * 
	 * @return a list of all opinions
	 */
	public List<Opinion> getAllOpinion();

	/**
	 * Function to update an opinion
	 * 
	 * @param opinion the opinion we want to update
	 */
	public void update(Opinion opinion);

	/**
	 * Function to delete an opinion
	 * 
	 * @param opinion the opinion we want to delete
	 */
	public void delete(Opinion opinion);

	/**
	 * Function to delete an opinion with its id
	 * 
	 * @param id_opinion the id of the opinion we want to delete
	 */
	public void deleteById(Integer id_opinion);
}
