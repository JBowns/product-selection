package com.bowns.productselection.controller;

import com.bowns.productselection.ProductSelectionApplication;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;


/**
 * @author Jacob Alexander Bowns
 *
 * This SpringBootTest interogates the ProductController endpoint
 *
 * Note: Test context will be derived from the SpringBootConfigurationContext
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductSelectionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Rule
    public ExpectedException assertException = ExpectedException.none();

    /**
     * Uses the RestTemplate to consume the API and
     * fetch all products using a valid customer ID
     * @throws Exception
     */
    @Test
    public void getProductsForValidCustomer() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", "customerID=LIV_CUST_93642");

        ResponseEntity<List> response = restTemplate.exchange("http://localhost:" + this.port + "/api/v1/products", HttpMethod.GET, new HttpEntity(requestHeaders), List.class);

        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    /**
     * Uses the RestTemplate to consume the API and attempt to
     * fetch all products using an invalid customer ID
     */
    @Test
    public void getProductsForInvalidCustomer() {
        assertException.expect(HttpClientErrorException.class);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.exchange("http://localhost:" + this.port + "/api/v1/products", HttpMethod.GET, null, List.class);
    }

}