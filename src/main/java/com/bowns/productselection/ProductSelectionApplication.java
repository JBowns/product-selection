package com.bowns.productselection;

import com.bowns.productselection.model.Category;
import com.bowns.productselection.model.Location;
import com.bowns.productselection.model.Product;
import com.bowns.productselection.repository.CategoryRepository;
import com.bowns.productselection.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Jacob Alexander Bowns
 *
 * SpringBootApplication entrypoint, consisiting of main method signature.
 *
 */
@SpringBootApplication
public class ProductSelectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSelectionApplication.class, args);
	}

	/**
	 * At application startup this function is responsible for populating
	 * the H2 in-memory database with relevant Products and Categories.
	 * @param categoryRepository
	 * @param productRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner populateDatabase(CategoryRepository categoryRepository, ProductRepository productRepository) {
		return (args) -> {

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
			product3.setName("Liverpool TV");
			product3.setLocation(Location.LIVERPOOL);
			product3.setCategory(category1);

			Product product4 = new Product();
			product4.setName("Sky News");
			product4.setLocation(Location.NON_SPECIFIC);
			product4.setCategory(category2);

			Product product5 = new Product();
			product5.setName("Sky Sports News");
			product5.setLocation(Location.NON_SPECIFIC);
			product5.setCategory(category2);

			categoryRepository.save(category1);
			categoryRepository.save(category2);

			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);

		};
	}

}
