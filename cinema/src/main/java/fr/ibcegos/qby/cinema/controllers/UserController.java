package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//////////
	//CREATE//
	//////////
	@PostMapping("/REST/user")
	public void createUser(@RequestBody User user) {
		userService.create(user);
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

	
}
