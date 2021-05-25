package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

}