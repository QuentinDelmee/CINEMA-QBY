package fr.ibcegos.qby.cinema.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.User;

/**
 * Interface DAO to manage Reservation DataBase
 * 
 * @author QBY
 *
 */
public interface ReservationDAO extends CrudRepository<Reservation, Integer>{
	public List<Reservation> findByIdUser(User idUser) ;
}
