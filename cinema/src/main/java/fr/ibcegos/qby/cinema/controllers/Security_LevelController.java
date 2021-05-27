package fr.ibcegos.qby.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ibcegos.qby.cinema.beans.Security_Level;
import fr.ibcegos.qby.cinema.services.Security_LevelService;

@RestController
public class Security_LevelController {
	 @Autowired 
	 private Security_LevelService security_LevelService;
	 
	//////////
	//CREATE//
	//////////
	 @PostMapping("/REST/security_Level")
	 public void create (@RequestBody Security_Level securityLevel) {
		 security_LevelService.create(securityLevel);
	 }
	 
	 
	//////////
	// GET  //
	//////////
	//Récupérer un niveau de sécurité par son id
	@GetMapping("/REST/getSecurity_LevelById/{id}")
	public Security_Level getSecurityLevelById(@PathVariable("id") Integer id_sl) {
		return security_LevelService.getSecurityLevelById(id_sl);
	}
	
	//Récupérer tous les niveaux de sécurité
	@GetMapping("/REST/getSecurity_LevelAllId")
	public List<Security_Level> getAllSecurityLevel(){
		return security_LevelService.getAllSecurityLevel();
	}
	
	//////////
	//UPDATE//
	//////////
	@PutMapping("/REST/updateSecurity_Level")
	public void getSecurity_LevelUpdate(@RequestBody Security_Level securityLevel) {
		security_LevelService.update(securityLevel);
	}
	  
	
	//////////
	//DELETE//
	//////////
	
	//Effacer un niveau de sécurité par son id
	@DeleteMapping("/REST/delelteSecurity_LevelById")
	public void delelteSecurity_LevelById(Integer id_sl) {
		security_LevelService.deleteById(id_sl);
	}
		
	//Effacer tous les niveaux de sécurité
	@DeleteMapping("/REST/delelteSecurity_LevelAll")
	public void delelteSecurity_LevelAll(Security_Level security_Level) {
		security_LevelService.delete(security_Level);
	}
	 

}
