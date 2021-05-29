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

import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.services.CinemaRoomService;
import fr.ibcegos.qby.cinema.services.OpinionService;
import fr.ibcegos.qby.cinema.services.UserService;

/**
 * Controller class for Opinion with basic CRUDs Mapping
 * 
 * @author QBY
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class OpinionController {
	@Autowired
	private OpinionService oservice;
	@Autowired
	private UserService uservice;
	@Autowired
	private CinemaRoomService crservice;

	/**
	 * Initialization function to potentially add data in DB
	 */
	@PostConstruct
	@Transactional
	public void init() {

	}

	/**
	 * Function to Map getOpinion to an URL
	 * 
	 * @param id the id of the opinion we want to get
	 * @return the opinion found in the DB (null if absent)
	 */
	@GetMapping("/REST/opinion/{id}")
	public Opinion getFromId(@PathVariable("id") Integer id) {
		return oservice.getOpinion(id);
	}

	/**
	 * Function to Map getAllOpinion to an URL
	 * 
	 * @return the list of all opinion in DB
	 */
	@GetMapping("/REST/opinion")
	public List<Opinion> getAll() {
		return oservice.getAllOpinion();
	}

	/**
	 * Function to Map POST create to an URL
	 * 
	 * @param opinion the opinion posted inside a form
	 * @return the opinion object we obtain
	 */
	@PostMapping("/REST/opinion")
	public Opinion addOpinion(@RequestBody Opinion opinion) {
		oservice.create(opinion);
		return opinion;
	}

	/**
	 * Function to map PUT update to an URL
	 * 
	 * @param opinion the opinion to update
	 * @return the updated opinion we obtain
	 */
	@PutMapping("/REST/opinion")
	public Opinion updateOpinion(@RequestBody Opinion opinion) {
		oservice.update(opinion);
		return opinion;
	}

	/**
	 * Function to Map DELETE deleteById to an URL
	 * 
	 * @param id the id of the opinion to delete
	 */
	@DeleteMapping("/REST/opinion/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		oservice.deleteById(id);
	}

}
