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

@RestController
public class SessionController {
	@Autowired
	private SessionService sservice;
	
	@PostConstruct
	@Transactional
	public void init() {

	}

	@GetMapping("/REST/session/{id}")
	public Session getFromId(@PathVariable("id") Integer id) {
		return sservice.getSession(id);
	}

	@GetMapping("/REST/session")
	public List<Session> getAll() {
		return sservice.getAllSession();
	}

	@PostMapping("/REST/session")
	public Session addAvion(@RequestBody Session session) {
		sservice.create(session);
		return session;
	}

	@PutMapping("/REST/session")
	public Session updateAvion(@RequestBody Session session) {
		sservice.update(session);
		return session;
	}
	
	@DeleteMapping("/REST/session/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		sservice.deleteById(id);
	}
}
