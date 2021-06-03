package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Quizz;
import fr.ibcegos.qby.cinema.services.QuizzService;

@RestController
public class QuizzController {
	@Autowired
	private QuizzService qservice;
	
	
	@GetMapping("/REST/quizz")
	public List<Quizz> getAll() {
		return qservice.findAll();
	}
}
