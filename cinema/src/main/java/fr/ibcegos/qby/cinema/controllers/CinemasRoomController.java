package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.CinemasRoom;
import fr.ibcegos.qby.cinema.beans.Seats;
import fr.ibcegos.qby.cinema.services.CinemasRoomService;

@RestController
public class CinemasRoomController {

	@Autowired
	private CinemasRoomService service;
	
	@PostConstruct
	@Transactional
	public void init() {
		CinemasRoom RoomA = new CinemasRoom(50,"SalleA","Niveau RDC", "4k");
		CinemasRoom RoomB = new CinemasRoom(100,"SalleB","Niveau 1", "4k");
		CinemasRoom RoomC = new CinemasRoom(150,"SalleC","Niveau 1", "4k");
		
		Seats a = new Seats(1,"a");
		Seats d = new Seats(10,"b");
		Seats c = new Seats(20,"d");
		
		RoomA.addSeats(d);
		RoomB.addSeats(c);
		RoomC.addSeats(a);
		
		service.create(RoomA);
		service.create(RoomB);
		service.create(RoomC);
	}
	
	@GetMapping("/REST/listesalle/")
	public List<CinemasRoom> getAllCinemasRoom(){
		return service.getAllCinemasRoom();
	}
}
