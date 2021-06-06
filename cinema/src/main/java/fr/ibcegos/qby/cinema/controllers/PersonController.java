package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Person;
import fr.ibcegos.qby.cinema.services.PersonService;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {
	@Autowired PersonService personService;
	
	
	//////////
	//CREATE//
	//////////
	@PostMapping("/REST/person")
	public void createPerson(Person person) {
		personService.create(person);
	}
	
	
	//////////
	// GET  //
	//////////
	// Récupérer une personne par son id
	@GetMapping("/REST/person/{id}")
	public Person getPersonId(@PathVariable ("id") Integer id_person) {
		return personService.getPersonId(id_person);
	}
	
	// Récupérer toutes les personnes
	@GetMapping("/REST/person")
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	
	
	//////////
	//UPDATE//
	//////////
	// Modifie  une personne 
	@PutMapping ("/REST/person")
	public void updatePerson (@RequestBody Person person) {
		personService.update(person);
	}
	
	//////////
	//DELETE//
	//////////
	
	//Supprime  une personne 
	@DeleteMapping("/REST/person")
	public void deleteAll (Person person) {
		personService.delete(person);
	}
	
	//Supprime un utilisateur par son id
	@DeleteMapping("/REST/person/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		personService.deleteById(id);
	}
	
	
} //---> ici se termine ma class controller
