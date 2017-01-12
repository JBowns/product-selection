package com.bowns.productselection.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Jacob Alexander Bowns
 *
 * Defines the model for a Category
 *
 */
@Entity
public class Category implements Serializable {

    private Long id;

    private String name;

    public Category() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        return name != null ? name.equals(category.name) : category.name == null;

    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
