
package fr.ibcegos.qby.cinema.daos;

import org.springframework.data.repository.CrudRepository;

import fr.ibcegos.qby.cinema.beans.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {

}
