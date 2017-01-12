package com.bowns.productselection.repository;

import com.bowns.productselection.model.Location;
import com.bowns.productselection.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jacob Alexander Bowns
 *
 * Here we're using the JPA and an in-memory H2 database to store and retrieve
 * our repository of products.
 *
 * Note: The repository implmentation will be created automatically at runtime.
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Custom JPA query method for searching by Location identifier.
     * @param location
     * @return
     */
    List<Product> findByLocation(final Location location);

    /**
     * Custom JPA query method for searching with a list of Location identifiers.
     * @param locations
     * @return
     */
    List<Product> findByLocationIn(final List<Location> locations);

}
