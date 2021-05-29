package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Session;
import fr.ibcegos.qby.cinema.services.SessionService;

/**
 * Controller class for Session with basic CRUDs Mapping
 * @author QBY
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class SessionController {
	@Autowired
	private SessionService sservice;
	
	/**
	 * Initialization function to potentially add data in DB
	 */
	@PostConstruct
	@Transactional
	public void init() {

	}
	/**
	 * Function to Map getSession to an URL
	 * 
	 * @param id the id of the session we want to get
	 * @return the session found in the DB (null if absent)
	 */
	@GetMapping("/REST/session/{id}")
	public Session getFromId(@PathVariable("id") Integer id) {
		return sservice.getSession(id);
	}
	/**
	 * Function to Map getAllSession to an URL
	 * 
	 * @return the list of all session in DB
	 */
	@GetMapping("/REST/session")
	public List<Session> getAll() {
		return sservice.getAllSession();
	}
	/**
	 * Function to Map POST create to an URL
	 * 
	 * @param session the session posted inside a form
	 * @return the session object we obtain
	 */
	@PostMapping("/REST/session")
	public Session addSession(@RequestBody Session session) {
		sservice.create(session);
		return session;
	}
	/**
	 * Function to map PUT update to an URL
	 * 
	 * @param session the session to update
	 * @return the updated session we obtain
	 */
	@PutMapping("/REST/session")
	public Session updateSession(@RequestBody Session session) {
		sservice.update(session);
		return session;
	}
	/**
	 * Function to Map DELETE deleteById to an URL
	 * 
	 * @param id the id of the session to delete
	 */
	@DeleteMapping("/REST/session/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		sservice.deleteById(id);
	}
}
