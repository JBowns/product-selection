package com.bowns.productselection.controller;

import com.bowns.productselection.exception.FailureException;
import com.bowns.productselection.exception.InvalidCustomerIDException;
import com.bowns.productselection.model.Location;
import com.bowns.productselection.model.Product;
import com.bowns.productselection.service.CatalogueService;
import com.bowns.productselection.service.CustomerLocationService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jacob Alexander Bowns
 *
 * This controller exposes product related endpoints
 *
 * Note: I decided to add a version to the API, this will
 * help to keep it maintainable and backwards compatible.
 *
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(ProductController.class);

    @Autowired
    private CustomerLocationService customerLocationService;

    @Autowired
    private CatalogueService catalogueService;

    /**
     * This function returns a list of products based on the customers ID
     * @param request
     * @return
     * @throws InvalidCustomerIDException
     * @throws FailureException
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsByCustomerID(final HttpServletRequest request) throws InvalidCustomerIDException, FailureException {

        String customerID = this.retrieveCustomerID(request);

        try {

            // Lets get the customers location based on their ID.
            Location location = this.customerLocationService.getLocationByCustomerID(customerID);

            // Return the products relevant to that location.
            return this.catalogueService.getProductsByLocation(location);

        } catch (FailureException ex) {
            ProductController.LOGGER.error("An error occurred whilst fetching products for CustomerID:" + customerID);

            // Although this particular use case hasn't been outlined in the specification,
            // Lets throw the exception and make use of our AbstractController.
            throw ex;
        }

    }

}
