package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Person;
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
	@Transactional
	public void create(User user) {
		if(user.getIdPerson()==null) {
		user.setIdPerson(new Person());}
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
	@Transactional
	public void update(User user) {
		userDAO.save(user);
	}

	//////////
	//DELETE//
	//////////
	@Override
	@Transactional
	public void delete(User user) {
		userDAO.deleteAll();	
	}

	@Override
	@Transactional
	public void deleteById(Integer id_user) {
		userDAO.deleteById(id_user);
		
	}


	@Override
	public boolean login(User user) {
		
		boolean verif = false;
		
		//Récupération de l'utilisateur de la BDD
		User tempUser = userDAO.findById(user.getId()).orElse(null);
		
		//Si l'id et le password rentré par l'utilisateur du site sont égales à celui de la BDD
		if(!((tempUser.getPwd().equals(user.getPwd()))) && (tempUser.getId().equals(user.getId()))) {
			//L'utilisateur peut accèder à son compte
			verif = false;
			System.out.println("No");
		}
		else {verif = true; System.out.println("YES");}
		
		return verif;
	}

}
