package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Commentary;

public interface CommentaryDAO extends CrudRepository<Commentary, Integer> {

}
