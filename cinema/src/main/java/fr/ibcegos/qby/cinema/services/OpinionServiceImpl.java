package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.daos.OpinionDAO;

@Service
public class OpinionServiceImpl implements OpinionService{
	@Autowired
	UserService uservice ;
	@Autowired
	CinemaRoomService crservice ;
	@Autowired
	OpinionDAO odao ;

	@Override
	public void create(Opinion opinion) {
		odao.save(opinion) ;
	}
	
	@Override
	public Opinion getOpinion(Integer id_opinion)
	{
		return odao.findById(id_opinion).orElse(null) ;
	}

	@Override
	public List<Opinion> getAllOpinion() {
		return (List<Opinion>) odao.findAll() ;
	}

	@Override
	public void update(Opinion opinion) {
		odao.save(opinion) ;
	}

	@Override
	public void delete(Opinion opinion) {
		// TODO Auto-generated method stub
		odao.delete(opinion);
	}

	@Override
	public void deleteById(Integer id_opinion) {
		// TODO Auto-generated method stub
		odao.deleteById(id_opinion);
	}

}
