package com.bowns.productselection.service;

import com.bowns.productselection.exception.FailureException;
import com.bowns.productselection.model.Location;

/**
 * @author Jacob Alexander Bowns
 *
 * CustomerLocationService Interface
 *
 */
public interface CustomerLocationService {

    /**
     * Fetch the location identifier for a given customer ID
     * @param customerID
     * @return
     * @throws FailureException
     */
    Location getLocationByCustomerID(final String customerID) throws FailureException;

}
