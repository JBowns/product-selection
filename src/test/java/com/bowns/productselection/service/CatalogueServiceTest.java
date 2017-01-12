package com.bowns.productselection.service;

import com.bowns.productselection.model.Category;
import com.bowns.productselection.model.Location;
import com.bowns.productselection.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Jacob Alexander Bowns
 *
 * SpringBootTest for CatalogueService
 *
 * Note: Test context will be derived from the SpringBootConfigurationContext
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogueServiceTest {

    @Autowired
    CatalogueService catalogueService;

    /**
     * Ensures all products available to London are correctly returned.
     */
    @Test
    public void getProductsForLondon() {

        List<Product> expectedProducts = new LinkedList<Product>();

        Category category1 = new Category();
        category1.setName("Sports");

        Category category2 = new Category();
        category2.setName("News");

        Product product1 = new Product();
        product1.setName("Arsenal TV");
        product1.setLocation(Location.LONDON);
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("Chelsea TV");
        product2.setLocation(Location.LONDON);
        product2.setCategory(category1);

        Product product3 = new Product();
        product3.setName("Sky News");
        product3.setLocation(Location.NON_SPECIFIC);
        product3.setCategory(category2);

        Product product4 = new Product();
        product4.setName("Sky Sports News");
        product4.setLocation(Location.NON_SPECIFIC);
        product4.setCategory(category2);

        expectedProducts.add(product1);
        expectedProducts.add(product2);
        expectedProducts.add(product3);
        expectedProducts.add(product4);

        List<Product> actualProducts = this.catalogueService.getProductsByLocation(Location.LONDON);

        assertEquals(expectedProducts, actualProducts);

    }

    /**
     * Ensures all products available to Liverpool are correctly returned.
     */
    @Test
    public void getProductsForLiverpool() {

        List<Product> expectedProducts = new LinkedList<Product>();

        Category category1 = new Category();
        category1.setName("Sports");

        Category category2 = new Category();
        category2.setName("News");

        Product product1 = new Product();
        product1.setName("Liverpool TV");
        product1.setLocation(Location.LIVERPOOL);
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("Sky News");
        product2.setLocation(Location.NON_SPECIFIC);
        product2.setCategory(category2);

        Product product3 = new Product();
        product3.setName("Sky Sports News");
        product3.setLocation(Location.NON_SPECIFIC);
        product3.setCategory(category2);

        expectedProducts.add(product1);
        expectedProducts.add(product2);
        expectedProducts.add(product3);

        List<Product> actualProducts = this.catalogueService.getProductsByLocation(Location.LIVERPOOL);

        assertEquals(expectedProducts, actualProducts);

    }

    /**
     * Ensures all non-location specific products are correctly returned.
     */
    @Test
    public void getProductsForNonSpecificLocation() {

        List<Product> expectedProducts = new LinkedList<Product>();

        Category category1 = new Category();
        category1.setName("News");

        Product product1 = new Product();
        product1.setName("Sky News");
        product1.setLocation(Location.NON_SPECIFIC);
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("Sky Sports News");
        product2.setLocation(Location.NON_SPECIFIC);
        product2.setCategory(category1);

        expectedProducts.add(product1);
        expectedProducts.add(product2);

        List<Product> actualProducts = this.catalogueService.getProductsByLocation(Location.NON_SPECIFIC);

        assertEquals(expectedProducts, actualProducts);

    }

}
