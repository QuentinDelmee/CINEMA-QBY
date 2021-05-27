package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.daos.CommentaryDAO;

@Service
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	CommentaryDAO dao;

		
	//////////
	//CREATE//
	//////////
	@Override
	public void create(Commentary commentary) {
		dao.save(commentary);
	}
	
	//////////
	// GET  //
	//////////
	@Override
	public Commentary getCommentaryById(Integer id_Commentary) {

		return dao.findById(id_Commentary).orElse(null);
	}

	
	@Override
	public List<Commentary> getAllCommentary() {

		return (List<Commentary>) dao.findAll();
	}
	

	//////////
	//UPDATE//
	//////////
	@Override
	@Transactional
	public void update(Commentary commentary) {
		dao.save(commentary);
	}

		
	//////////
	//DELETE//
	//////////
	@Override
	public void delete(Commentary commentary) {
		dao.delete(commentary);
	}

	@Override
	public void deleteById(Integer id_Commentary) {
		dao.deleteById(id_Commentary);
	}

}
