package fr.ibcegos.qby.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibcegos.qby.cinema.beans.Security_Level;
import fr.ibcegos.qby.cinema.daos.Security_LevelDAO;
@Service
public class Security_LevelServiceImpl implements Security_LevelService{

	@Autowired
	Security_LevelDAO security_LevelDAO;
	
	
	@Override
	public void create(Security_Level securityLevel) {
		security_LevelDAO.save(securityLevel);
		
	}

	@Override
	public Security_Level getSecurityLevelById(Integer id_sl) {
		return security_LevelDAO.findById(id_sl).orElse(null);
	}

	@Override
	public List<Security_Level> getAllSecurityLevel() {
		return (List<Security_Level>) security_LevelDAO.findAll();
	}

	@Override
	public void update(Security_Level securityLevel) {
		security_LevelDAO.save(securityLevel);		
	}

	@Override
	public void delete(Security_Level securityLevel) {
		security_LevelDAO.deleteAll();
		
	}

	@Override
	public void deleteById(Integer id_sl) {
		security_LevelDAO.deleteById(id_sl);
	}
}
