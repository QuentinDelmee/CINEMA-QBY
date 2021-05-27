package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.SecurityLevel;

public interface SecurityLevelDAO  extends CrudRepository<SecurityLevel, Integer> {

}
