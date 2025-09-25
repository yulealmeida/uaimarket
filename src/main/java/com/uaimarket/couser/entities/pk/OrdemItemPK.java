package com.uaimarket.couser.entities.pk;

import com.uaimarket.couser.entities.Order;
import com.uaimarket.couser.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class OrdemItemPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;


    public Order getOrder () {
        return order;
    }

    public OrdemItemPK setOrder (Order order) {
        this.order = order;
        return this;
    }

    public Product getProduct () {
        return product;
    }

    public OrdemItemPK setProduct (Product product) {
        this.product = product;
        return this;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        OrdemItemPK that = (OrdemItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode () {
        return Objects.hash(order, product);
    }
}
