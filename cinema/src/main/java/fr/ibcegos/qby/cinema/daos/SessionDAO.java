package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Session;

public interface SessionDAO extends CrudRepository<Session, Integer>{

}
