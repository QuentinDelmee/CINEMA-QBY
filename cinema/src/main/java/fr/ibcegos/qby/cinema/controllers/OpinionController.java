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

@RestController
public class OpinionController {
	@Autowired
	private OpinionService oservice;
	@Autowired
	private UserService uservice;
	@Autowired
	private CinemaRoomService crservice;
	
	@PostConstruct
	@Transactional
	public void init() {
		
	}
	
	@GetMapping("/REST/opinion/{id}")
	public Opinion getFromId(@PathVariable("id") Integer id) {
		return oservice.getOpinion(id);
	}

	@GetMapping("/REST/opinion")
	public List<Opinion> getAll() {
		return oservice.getAllOpinion();
	}

	@PostMapping("/REST/opinion")
	public Opinion addAvion(@RequestBody Opinion opinion) {
		oservice.create(opinion);
		return opinion;
	}

	@PutMapping("/REST/opinion")
	public Opinion updateAvion(@RequestBody Opinion opinion) {
		oservice.update(opinion);
		return opinion;
	}
	
	@DeleteMapping("/REST/opinion/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		oservice.deleteById(id);
	}
	
}
