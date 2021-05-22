package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Seats;

public interface SeatsDAO extends CrudRepository<Seats, Integer> {

}
