package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Reservation;

public interface ReservationDAO extends CrudRepository<Reservation, Integer>{

}
