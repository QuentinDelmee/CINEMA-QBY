package fr.ibcegos.qby.cinema.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.Purchase;
import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.services.PersonService;
import fr.ibcegos.qby.cinema.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PersonService personService;
	
	
	//////////
	//CREATE//
	//////////
	@PostMapping("/REST/user")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}
	
	@RequestMapping("/REST/user/")
	public boolean isEmailFree(@RequestBody String email)
	{
		return personService.isEmailFree(email) ;
	}
	
	
	//////////
	// GET  //
	//////////
	@GetMapping("/REST/user/{id}")
	public User getUserId (@PathVariable("id") Integer id) {
		return userService.getUserId(id);
	}
	
	@GetMapping("/REST/user")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

	//////////
	//UPDATE//
	//////////
	@PutMapping("/REST/user")
	public void update (@RequestBody User user) {
		userService.update(user);
	}
	
	//////////
	//DELETE//
	//////////
	@DeleteMapping("/REST/user/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.deleteById(id);
	}

	//////////
	//Log In//
	//////////
	@RequestMapping("/REST/user/login")
	public boolean login(@RequestBody User user) {
		boolean verif = userService.login(user);
		return verif;
	}
//	@RequestMapping("/user")
//    public Principal user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization")
//          .substring("Basic".length()).trim();
//        return () ->  new String(Base64.getDecoder()
//          .decode(authToken)).split(":")[0];
//    }
//	
	@GetMapping("/REST/user/{id}/opinions")
	public List<Opinion> findOpinionUser(@PathVariable("id") Integer id) {
		return userService.findOpinionUser(id);
	}
	
	@GetMapping("/REST/user/{id}/commentarys")
	public List<Commentary> findCommentaryUser(@PathVariable("id") Integer id) {
		return userService.findCommentaryUser(id);
	}
	
	@GetMapping("/REST/user/{id}/reservations")
	public List<Reservation> findReservationUser(@PathVariable("id") Integer id) {
		return userService.findReservationUser(id);
	}
	
	@GetMapping("/REST/user/{id}/reservations/futur")
	public List<Reservation> getUserFutureReservation(@PathVariable Integer id) {

		return (userService.findReservationUser(id)
				.stream()
				.filter( elem -> elem.getIdDate()
				.isAfter(LocalDateTime.now() ))
				.collect(Collectors.toList()));
	}
	
	@GetMapping("/REST/user/{id}/purchases")
	public List<Purchase> findPurchaseUser(@PathVariable("id") Integer id) {
		return userService.findPurchaseUser(id);
	}
	
	
	
}
