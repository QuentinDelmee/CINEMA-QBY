package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Session;

/**
 * Interface DAO to manage Session DataBase
 * 
 * @author QBY
 *
 */
public interface SessionDAO extends CrudRepository<Session, Integer>{

}
