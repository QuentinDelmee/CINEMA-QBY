package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Movie;


public interface MovieDAO extends CrudRepository<Movie, Integer> {

}
