package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.daos.UserDAO;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	//////////
	//CREATE//
	//////////
	@Override
	public void create(User user) {
		userDAO.save(user);
		
	}

	
	//////////
	// GET  //
	//////////
	
	@Override
	public User getUserId(Integer id_user) {
		return userDAO.findById(id_user).orElse(null);
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) userDAO.findAll();
	}

	
	//////////
	//UPDATE//
	//////////
	@Override
	public void update(User user) {
		userDAO.save(user);
	}

	//////////
	//DELETE//
	//////////
	@Override
	public void delete(User user) {
		userDAO.deleteAll();	
	}

	@Override
	public void deleteById(Integer id_user) {
		userDAO.deleteById(id_user);
		
	}

}
