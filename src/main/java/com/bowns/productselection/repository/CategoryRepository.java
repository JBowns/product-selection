package com.bowns.productselection.repository;

import com.bowns.productselection.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jacob Alexander Bowns
 *
 * Here we're using the JPA and an in-memory H2 database to store and retrieve
 * our repository of categories.
 *
 * Note: The repository implmentation will be created automatically at runtime.
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * Custom JPA query method for searching by Category name.
     * @param name
     * @return
     */
    Category findByName(final String name);

}
