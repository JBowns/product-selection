package com.bowns.productselection.service.impl;

import com.bowns.productselection.model.Location;
import com.bowns.productselection.model.Product;
import com.bowns.productselection.repository.ProductRepository;
import com.bowns.productselection.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jacob Alexander Bowns
 *
 * CatalogueService Implementation
 *
 */
@Service
public class CatalogueServiceImpl implements CatalogueService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductsByLocation(Location location) {

        List<Location> locations = new LinkedList<Location>();
        //Add the non-specific location identifier.
        locations.add(Location.NON_SPECIFIC);
        locations.add(location);

        return this.productRepository.findByLocationIn(locations);

    }

}
