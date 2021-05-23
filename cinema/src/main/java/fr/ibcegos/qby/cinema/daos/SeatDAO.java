package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Seat;

public interface SeatDAO extends CrudRepository<Seat, Integer> {

}
