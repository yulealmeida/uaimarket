package com.uaimarket.couser.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uaimarket.couser.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;



@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;






    public Order () {
    }

    public Order (Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId () {
        return id;
    }

    public Order setId (Long id) {
        this.id = id;
        return this;
    }

    public Instant getMoment () {
        return moment;
    }

    public Order setMoment (Instant moment) {
        this.moment = moment;
        return this;
    }

    public User getClient () {
        return client;
    }

    public Order setClient (User client) {
        this.client = client;
        return this;
    }

    public OrderStatus getOrderStatus () {
        return OrderStatus.valueOf(orderStatus);
    }

    public Order setOrderStatus (OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }

        return this;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(id);
    }
}
