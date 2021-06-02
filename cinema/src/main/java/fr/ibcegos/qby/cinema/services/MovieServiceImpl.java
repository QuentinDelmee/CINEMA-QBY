package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.Movie;
import fr.ibcegos.qby.cinema.beans.Session;
import fr.ibcegos.qby.cinema.daos.CommentaryDAO;
import fr.ibcegos.qby.cinema.daos.MovieDAO;
import fr.ibcegos.qby.cinema.daos.SessionDAO;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDAO dao;
	@Autowired
	CommentaryDAO codao;
	@Autowired
	SessionDAO sedao;

	//////////
	// CREATE//
	//////////
	@Override
	@Transactional
	public void create(Movie movie) {
		dao.save(movie);
	}

	//////////
	// GET //
	//////////
	@Override
	public Movie getMovieById(Integer id_Movie) {
		return dao.findById(id_Movie).orElse(null);
	}

	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) dao.findAll();
	}

	//////////
	// UPDATE//
	//////////
	@Override
	@Transactional
	public void update(Movie movie) {
		dao.save(movie);
	}

	//////////
	// DELETE//
	//////////
	@Override
	@Transactional
	public void delete(Movie movie) {
//		for (Session session : movie.getLstSessions()) {
//			sedao.delete(session);
//		}
//		for (Commentary comment : movie.getLstCommentarys()) {
//			codao.delete(comment);
//		}
		dao.delete(movie);
	}

	@Override
	@Transactional
	public void deleteById(Integer id_Movie) {
		Movie movie = dao.findById(id_Movie).orElse(null);
		if (movie != null) {
//			for (Session session : movie.getLstSessions()) {
//				System.out.println(movie.getLstSessions().size());
//				sedao.delete(session);
//			}
//			for (Commentary comment : movie.getLstCommentarys()) {
//				codao.delete(comment);
//			}
			dao.delete(movie);
		}
	}

	@Override
	public List<Commentary> findCommentaryMovie(Integer id_Movie) {
		// TODO Auto-generated method stub
		return dao.findById(id_Movie).orElse(new Movie()).getLstCommentarys() ;
	}

	@Override
	public List<Session> findSessionMovie(Integer id_Movie) {
		// TODO Auto-generated method stub
		return dao.findById(id_Movie).orElse(new Movie()).getLstSessions() ;
	}

}
