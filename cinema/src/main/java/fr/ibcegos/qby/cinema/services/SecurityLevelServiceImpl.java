package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.SecurityLevel;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.daos.SecurityLevelDAO;
@Service
public class SecurityLevelServiceImpl implements SecurityLevelService{

	@Autowired
	SecurityLevelDAO securityLevelDAO;
	
	
	@Override
	public void create(SecurityLevel securityLevel) {
		securityLevelDAO.save(securityLevel);
		
	}

	@Override
	public SecurityLevel getSecurityLevelById(Integer idsl) {
		return securityLevelDAO.findById(idsl).orElse(null);
	}

	@Override
	public List<SecurityLevel> getAllSecurityLevel() {
		return (List<SecurityLevel>) securityLevelDAO.findAll();
	}

	@Override
	public void update(SecurityLevel securityLevel) {
		securityLevelDAO.save(securityLevel);		
	}

	@Override
	public void delete(SecurityLevel securityLevel) {
		securityLevelDAO.deleteAll();
		
	}

	@Override
	public void deleteById(Integer idsl) {
		securityLevelDAO.deleteById(idsl);
	}

	@Override
	public List<User> findUserSecurityLevel(Integer idsl) {
		// TODO Auto-generated method stub
		return securityLevelDAO.findById(idsl).orElse(new SecurityLevel()).getAllUsers() ;
	}
}
