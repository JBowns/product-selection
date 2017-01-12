package com.bowns.productselection.service.impl;

import com.bowns.productselection.exception.FailureException;
import com.bowns.productselection.model.Location;
import com.bowns.productselection.service.CustomerLocationService;
import org.springframework.stereotype.Service;

/**
 * @author Jacob Alexander Bowns
 *
 * CustomerLocationService Implementation
 *
 */
@Service
public class CustomerLocationServiceImpl implements CustomerLocationService {

    @Override
    public Location getLocationByCustomerID(String customerID) throws FailureException {
        //I decided to add a simple textual identifier to differentiate between each location.
        if (customerID.contains("LDN")) {
            return Location.LONDON;
        } else if (customerID.contains("LIV")) {
            return Location.LIVERPOOL;
        } else if (customerID.contains("OTHER")) {
            return Location.NON_SPECIFIC;
        } else {
            //Assuming we don't find a relevant location lets throw our FailureException, as outlined in the specification.
            throw new FailureException("Unable to determine relevant location identifier for customerID '" + customerID + "'");
        }
    }

}
