package com.uaimarket.couser.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @Transient
    private Set<Product> products = new HashSet<>();

    public Category () {
    }

    public Category (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId () {
        return id;
    }

    public Category setId (Long id) {
        this.id = id;
        return this;
    }

    public String getName () {
        return name;
    }

    public Category setName (String name) {
        this.name = name;
        return this;
    }
    public Set<Product> getProducts () {
        return products;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(id);
    }


}
