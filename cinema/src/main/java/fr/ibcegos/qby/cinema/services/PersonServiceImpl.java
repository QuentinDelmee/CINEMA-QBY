package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Person;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.daos.PersonDAO;
@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	PersonDAO personDAO;
	
	@Override
	public void create(Person person) {
		personDAO.save(person);
		
	}

	@Override
	public Person getPersonId(Integer id_person) {
		
		return personDAO.findById(id_person).orElse(null);
	}


	@Override
	public List<Person> getAllPerson() {
		
		return (List<Person>) personDAO.findAll();
	}

	@Override
	public void update(Person person) {
		personDAO.save(person);
	}

	@Override
	public void delete(Person person) {
		personDAO.deleteAll();
	}

	@Override
	public void deleteById(Integer id_user) {
		personDAO.deleteById(id_user);
	}




}
