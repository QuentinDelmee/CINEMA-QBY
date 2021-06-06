package fr.ibcegos.qby.cinema.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.User;

/**
 * Interface DAO to manage Opinion DataBase
 * 
 * @author QBY
 *
 */
public interface OpinionDAO extends CrudRepository<Opinion, Integer> {
	public List<Opinion> findByIdUser(User idUser);
}
