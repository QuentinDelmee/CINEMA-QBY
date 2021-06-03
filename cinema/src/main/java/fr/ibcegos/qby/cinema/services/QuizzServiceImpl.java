package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Quizz;
import fr.ibcegos.qby.cinema.daos.QuizzDAO;

@Service
public class QuizzServiceImpl implements QuizzService {
	@Autowired
	private QuizzDAO qdao; 

	@Override
	public List<Quizz> findAll() {
		return (List<Quizz>) qdao.findAll();
	}

}
