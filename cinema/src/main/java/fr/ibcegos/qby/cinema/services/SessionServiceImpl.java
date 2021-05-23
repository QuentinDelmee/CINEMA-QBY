package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Session;
import fr.ibcegos.qby.cinema.daos.SessionDAO;

@Service
public class SessionServiceImpl implements SessionService {
	@Autowired
	CinemaRoomService crservice;
	@Autowired
	MovieService mservice;
	@Autowired
	SessionDAO sdao;

	@Override
	public void create(Session session) {
		// TODO Auto-generated method stub
		sdao.save(session);
	}

	@Override
	public Session getSession(Integer id_session) {
		return sdao.findById(id_session).orElse(null);
	}

	@Override
	public List<Session> getAllSession() {
		return (List<Session>) sdao.findAll();
	}

	@Override
	public void update(Session session) {
		sdao.save(session);
	}

	@Override
	public void delete(Session session) {
		sdao.delete(session);
	}

	@Override
	public void deleteById(Integer id_session) {
		// TODO Auto-generated method stub
		sdao.deleteById(id_session);
	}

}
