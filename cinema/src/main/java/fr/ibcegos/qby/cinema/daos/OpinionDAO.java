package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Opinion;

/**
 * Interface DAO to manage Opinion DataBase
 * 
 * @author QBY
 *
 */
public interface OpinionDAO extends CrudRepository<Opinion, Integer> {

}
