package com.uaimarket.couser.repositories;

import com.uaimarket.couser.entities.Category;
import com.uaimarket.couser.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
