package com.bowns.productselection.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Jacob Alexander Bowns
 *
 * Defines the model for a Product
 *
 */
@Entity
public class Product implements Serializable {

    private Long id;
    private String name;
    private Location location;
    private Category category;

    public Product() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToOne()
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (location != product.location) return false;
        return category != null ? category.equals(product.category) : product.category == null;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", category=" + category +
                '}';
    }
}
