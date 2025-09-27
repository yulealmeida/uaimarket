package com.uaimarket.couser.repositories;

import com.uaimarket.couser.entities.Order;
import com.uaimarket.couser.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
