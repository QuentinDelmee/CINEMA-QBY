package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Session;

/**
 * 
 * Interface Service for the Session Class/Entity
 * 
 * @author QBY
 *
 */
public interface SessionService {

	/**
	 * Function to create an session in DB
	 * 
	 * @param session the session to add in DB
	 */
	public void create(Session session);

	/**
	 * Function to obtain an session with specific id
	 * 
	 * @param id_session the id of the session searched
	 * @return Session from DB
	 */
	public Session getSession(Integer id_session);

	/**
	 * Function to obtain all session
	 * 
	 * @return a list of all sessions
	 */
	public List<Session> getAllSession();

	/**
	 * Function to update a session
	 * 
	 * @param session the session we want to update
	 */
	public void update(Session session);

	/**
	 * Function to delete a session
	 * 
	 * @param session the session we want to delete
	 */
	public void delete(Session session);

	/**
	 * Function to delete a session with its id
	 * 
	 * @param id_session the id of the session we want to delete
	 */
	public void deleteById(Integer id_session);
}
