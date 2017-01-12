package com.bowns.productselection.service;

import com.bowns.productselection.exception.FailureException;
import com.bowns.productselection.model.Location;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Jacob Alexander Bowns
 *
 * This SpringBootTest ensures that all each customer ID
 * correctly maps to its accompanying location identifer,
 * or throws the relevant exception where appropriate.
 *
 * Note: Test context will be derived from the SpringBootConfigurationContext
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerLocationServiceTest {

    @Autowired
    CustomerLocationService customerLocationService;

    @Rule
    public ExpectedException assertException = ExpectedException.none();

    @Test
    public void getLocationForLondonBasedCustomerID() throws FailureException {
        Location location = this.customerLocationService.getLocationByCustomerID("LDN_CUST_65720");
        assertEquals(location, Location.LONDON);
    }

    @Test
    public void getLocationForLiverpoolBasedCustomerID() throws FailureException {
        Location location = this.customerLocationService.getLocationByCustomerID("LIV_CUST_65720");
        assertEquals(location, Location.LIVERPOOL);
    }

    @Test
    public void getLocationForGenericCustomerID() throws FailureException {
        Location location = this.customerLocationService.getLocationByCustomerID("OTHER_CUST_78632");
        assertEquals(location, Location.NON_SPECIFIC);
    }

    @Test
    public void getLocationForInvalidCustomerID() throws FailureException {
        assertException.expect(FailureException.class);
        Location location = this.customerLocationService.getLocationByCustomerID("INVALID_CUSTOMER_ID");
    }

}
