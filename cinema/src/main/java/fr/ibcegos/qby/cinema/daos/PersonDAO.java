package fr.ibcegos.qby.cinema.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {
	public List<Person> findByEmail(String email);
}