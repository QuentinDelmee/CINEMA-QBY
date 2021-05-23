package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Movie;
import fr.ibcegos.qby.cinema.daos.CinemaRoomDAO;
import fr.ibcegos.qby.cinema.daos.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDAO dao;
	
	
	//////////
	//CREATE//
	//////////
	@Override
	@Transactional
	public void create(Movie movie) {
		dao.save(movie);
	}

	
	//////////
	// GET  //
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
	//UPDATE//
	//////////
	@Override
	@Transactional
	public void update(Movie movie) {
		dao.save(movie);
	}

	//////////
	//DELETE//
	//////////
	@Override
	@Transactional
	public void delete(Movie movie) {
		dao.delete(movie);
	}

	@Override
	@Transactional
	public void deleteById(Integer id_Movie) {
		dao.deleteById(id_Movie);
	}

}
