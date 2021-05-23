package fr.ibcegos.qby.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.services.ReservationService;

@RestController
public class ReservationController {
	@Autowired
	private ReservationService service;
}
