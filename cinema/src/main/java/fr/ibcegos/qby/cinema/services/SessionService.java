package fr.ibcegos.qby.cinema.services;

import java.util.List;

import fr.ibcegos.qby.cinema.beans.Session;

public interface SessionService {
	public void create(Session cinemaRoom);

	public Session getSession(Integer id_session);

	public List<Session> getAllSession();

	public void update(Session cinemaRoom);

	public void delete(Session cinemaRoom);
	
	public void deleteById(Integer id_session);
}
