package fr.ibcegos.qby.cinema.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.Person;
import fr.ibcegos.qby.cinema.beans.Purchase;
import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.daos.SecurityLevelDAO;
import fr.ibcegos.qby.cinema.daos.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	SecurityLevelDAO slDAO; 
	@Autowired
	PersonService personService ;

	//////////
	// CREATE//
	//////////
	@Override
	@Transactional
	public User create(User user) {
		if (user.getIdPerson() == null) {
			user.setIdPerson(new Person());
		}
		user.setIdSecurityLevel( slDAO.findById(1).orElse(null) );
		userDAO.save(user);
		return user;
	}
	
	@Override
	@Transactional
	public Integer createVerif(User user)
	{
		if (user.getIdPerson() == null) {
			user.setIdPerson(new Person());
			user.setIdSecurityLevel( slDAO.findById(1).orElse(null) );
			userDAO.save(user);
			return user.getId() ;
		}
		else if( personService.isEmailFree(user.getIdPerson().getEmail() ))
		{
			user.setIdSecurityLevel( slDAO.findById(1).orElse(null) );
			userDAO.save(user);
			return user.getId() ;
		}
		
		return 0 ;
	}

	//////////
	// GET //
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
	// UPDATE//
	//////////
	@Override
	@Transactional
	public void update(User user) {
		userDAO.save(user);
	}

	//////////
	// DELETE//
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

		// Récupération de l'utilisateur de la BDD
		User tempUser = userDAO.findById(user.getId()).orElse(null);

		if (tempUser == null || user == null)
			return false;
		else {
			// Si l'id et le password rentré par l'utilisateur du site sont égales à celui
			// de la BDD
			if (tempUser.getPwd().equals(user.getPwd()) && tempUser.getId().equals(user.getId())
					&& tempUser.getPseudo().equalsIgnoreCase(user.getPseudo())) {
				// L'utilisateur peut accèder à son compte
				verif = true;
			} else {
				verif = false;
			}

			return verif;
		}

	}

	@Override
	public List<Opinion> findOpinionUser(Integer id_user) {
		// TODO Auto-generated method stub
		return userDAO.findById(id_user).orElse(new User()).getMyOpinions();
	}

	@Override
	public List<Commentary> findCommentaryUser(Integer id_user) {
		// TODO Auto-generated method stub
		return userDAO.findById(id_user).orElse(new User()).getMyCommentary();
	}

	@Override
	public List<Purchase> findPurchaseUser(Integer id_user) {
		// TODO Auto-generated method stub
		return userDAO.findById(id_user).orElse(new User()).getMyPurchase();
	}

	@Override
	public List<Reservation> findReservationUser(Integer id_user) {
		// TODO Auto-generated method stub
		return userDAO.findById(id_user).orElse(new User()).getMyReservation();
	}

}
