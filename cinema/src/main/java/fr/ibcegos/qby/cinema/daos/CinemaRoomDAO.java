package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;

public interface CinemaRoomDAO extends CrudRepository<CinemaRoom, Integer> {

}
