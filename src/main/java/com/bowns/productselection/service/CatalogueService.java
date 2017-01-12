package com.bowns.productselection.service;

import com.bowns.productselection.model.Location;
import com.bowns.productselection.model.Product;

import java.util.List;

/**
 * @author Jacob Alexander Bowns
 *
 * CatalogueService Interface
 *
 */
public interface CatalogueService {

    /**
     * Fetch all available products by location
     * @param location
     * @return
     */
    List<Product> getProductsByLocation(Location location);

}
