package com.uaimarket.couser.entities;

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
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;



    public Order () {
    }

    public Order (Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
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
