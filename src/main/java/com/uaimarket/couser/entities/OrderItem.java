package com.uaimarket.couser.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uaimarket.couser.entities.pk.OrdemItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();


    private Integer quantity;
    private Double price;

    public OrderItem () {
    }

    public OrderItem (Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder () {
        return id.getOrder();
    }

    public void setOrder (Order order) {
        id.setOrder(order);
    }

    public Product getProduct () {
        return id.getProduct();
    }

    public void setProduct (Product product) {
        id.setProduct(product);
    }

    public Double getPrice () {
        return price;
    }

    public OrderItem setPrice (Double price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity () {
        return quantity;
    }

    public OrderItem setQuantity (Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(id);
    }
}
