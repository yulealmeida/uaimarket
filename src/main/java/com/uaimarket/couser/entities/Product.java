package com.uaimarket.couser.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @Transient
   private Set<Category> categories = new HashSet<>();

    public Product () {
    }

    public Product (Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId () {
        return id;
    }

    public Product setId (Long id) {
        this.id = id;
        return this;
    }

    public String getName () {
        return name;
    }

    public Product setName (String name) {
        this.name = name;
        return this;
    }

    public String getDescription () {
        return description;
    }

    public Product setDescription (String description) {
        this.description = description;
        return this;
    }

    public Double getPrice () {
        return price;
    }

    public Product setPrice (Double price) {
        this.price = price;
        return this;
    }

    public String getImgUrl () {
        return imgUrl;
    }

    public Product setImgUrl (String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(id);
    }
}
