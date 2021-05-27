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

import fr.ibcegos.qby.cinema.beans.SecurityLevel;
import fr.ibcegos.qby.cinema.services.SecurityLevelService;

@RestController
public class SecurityLevelController {
	 @Autowired 
	 private SecurityLevelService securityLevelService;
	 
	//////////
	//CREATE//
	//////////
	 @PostMapping("/REST/securityLevel")
	 public void create (@RequestBody SecurityLevel securityLevel) {
		 securityLevelService.create(securityLevel);
	 }
	 
	 
	//////////
	// GET  //
	//////////
	//Récupérer un niveau de sécurité par son id
	@GetMapping("/REST/getSecurityLevelById/{id}")
	public SecurityLevel getSecurityLevelById(@PathVariable("id") Integer idsl) {
		return securityLevelService.getSecurityLevelById(idsl);
	}
	
	//Récupérer tous les niveaux de sécurité
	@GetMapping("/REST/getSecurityLevelAllId")
	public List<SecurityLevel> getAllSecurityLevel(){
		return securityLevelService.getAllSecurityLevel();
	}
	
	//////////
	//UPDATE//
	//////////
	@PutMapping("/REST/updateSecurityLevel")
	public void getSecurityLevelUpdate(@RequestBody SecurityLevel securityLevel) {
		securityLevelService.update(securityLevel);
	}
	  
	
	//////////
	//DELETE//
	//////////
	
	//Effacer un niveau de sécurité par son id
	@DeleteMapping("/REST/delelteSecurityLevelById")
	public void delelteSecurityLevelById(Integer idsl) {
		securityLevelService.deleteById(idsl);
	}
		
	//Effacer tous les niveaux de sécurité
	@DeleteMapping("/REST/delelteSecurityLevelAll")
	public void delelteSecurityLevelAll(SecurityLevel securityLevel) {
		securityLevelService.delete(securityLevel);
	}
	 

}
