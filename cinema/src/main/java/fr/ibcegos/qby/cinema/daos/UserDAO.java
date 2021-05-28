package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.User;

public interface UserDAO  extends CrudRepository<User, Integer> {

}
