package com.bowns.productselection.repository;

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
 * This SpringBootTest validates the repositories ability to persist
 * and retrieve Products.
 *
 * Note: Test context will be derived from the SpringBootConfigurationContext
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;

	/**
	 * Ensures all products available to London are correctly persisted.
	 */
	@Test
	public void getProductsForLondon() {

		List<Product> expectedProducts = new LinkedList<Product>();

		Category category1 = new Category();
		category1.setName("Sports");

		Product product1 = new Product();
		product1.setName("Arsenal TV");
		product1.setLocation(Location.LONDON);
		product1.setCategory(category1);

		Product product2 = new Product();
		product2.setName("Chelsea TV");
		product2.setLocation(Location.LONDON);
		product2.setCategory(category1);

		expectedProducts.add(product1);
		expectedProducts.add(product2);

		List<Product> actualProducts = this.productRepository.findByLocation(Location.LONDON);

		assertEquals(expectedProducts, actualProducts);

	}

	/**
	 * Ensures all products available to Liverpool are correctly persisted.
	 */
	@Test
	public void getProductsForLiverpool() {

		List<Product> expectedProducts = new LinkedList<Product>();

		Category category1 = new Category();
		category1.setName("Sports");

		Product product1 = new Product();
		product1.setName("Liverpool TV");
		product1.setLocation(Location.LIVERPOOL);
		product1.setCategory(category1);

		expectedProducts.add(product1);

		List<Product> actualProducts = this.productRepository.findByLocation(Location.LIVERPOOL);

		assertEquals(expectedProducts, actualProducts);

	}

	/**
	 * Ensures all non-location specific products are correctly persisted.
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

		List<Product> actualProducts = this.productRepository.findByLocation(Location.NON_SPECIFIC);

		assertEquals(expectedProducts, actualProducts);

	}

}
