package com.bowns.productselection.repository;

import com.bowns.productselection.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Jacob Alexander Bowns
 *
 * This SpringBootTest validates the repositories ability to persist
 * and retrieve Categories.
 *
 * Note: Test context will be derived from the SpringBootConfigurationContext
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    /**
     * Ensures the Sports Category is stored and retrieved correctly.
     */
    @Test
    public void getCategoryForSports() {

        Category expectedCategory = new Category();
        expectedCategory.setName("Sports");

        Category actualCategory = this.categoryRepository.findByName("Sports");

        assertEquals(expectedCategory, actualCategory);
    }

    /**
     * Ensures the News Category is stored and retrieved correctly.
     */
    @Test
    public void getCategoryForNews() {

        Category expectedCategory = new Category();
        expectedCategory.setName("News");

        Category actualCategory = this.categoryRepository.findByName("News");

        assertEquals(expectedCategory, actualCategory);
    }

}
