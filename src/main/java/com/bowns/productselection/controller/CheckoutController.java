package com.bowns.productselection.controller;

import com.bowns.productselection.exception.InvalidCustomerIDException;
import com.bowns.productselection.model.Product;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jacob Alexander Bowns
 *
 * Just to finish off the ConfirmationPage I decided to add
 * an endpoint for posting the selected products.
 *
 */
@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(CheckoutController.class);

    /**
     * This endpoint demonstrates the use of POST to retrieve a list of products
     * @param request
     * @param products
     * @throws InvalidCustomerIDException
     */
    @RequestMapping(method = RequestMethod.POST)
    public void checkout(final HttpServletRequest request, @RequestBody List<Product> products) throws InvalidCustomerIDException {

        String customerID = this.retrieveCustomerID(request);
        String selectedProducts = products.stream().map(product -> product.getName()).collect(Collectors.joining(", "));

        LOGGER.info("Customer '" + customerID + "' selected the following products: " + selectedProducts);

    }

}
