package fr.ibcegos.qby.cinema.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.User;

public interface CommentaryDAO extends CrudRepository<Commentary, Integer> {
	public List<Commentary> findByIdUser(User idUser);
}
