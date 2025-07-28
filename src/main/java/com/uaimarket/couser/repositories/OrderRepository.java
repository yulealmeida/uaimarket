package com.uaimarket.couser.repositories;

import com.uaimarket.couser.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
