package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Session;
import fr.ibcegos.qby.cinema.daos.CinemaRoomDAO;
import fr.ibcegos.qby.cinema.daos.MovieDAO;
import fr.ibcegos.qby.cinema.daos.SessionDAO;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
	@Autowired
	CinemaRoomDAO crdao;
	@Autowired
	MovieDAO mdao;
	@Autowired
	SessionDAO sdao;

	@Override
	@Transactional
	public void create(Session session) {
		// TODO Auto-generated method stub
		sdao.save(session);
//		crdao.save(session.getIdCinemaRoom()) ;
//		mdao.save(session.getIdMovie()) ;
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
	@Transactional
	public void update(Session session) {
		sdao.save(session);
	}

	@Override
	@Transactional
	public void delete(Session session) {
		sdao.delete(session);
	}

	@Override
	@Transactional
	public void deleteById(Integer id_session) {
		// TODO Auto-generated method stub
		sdao.deleteById(id_session);
	}

}
