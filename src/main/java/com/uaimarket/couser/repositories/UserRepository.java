package com.uaimarket.couser.repositories;

import com.uaimarket.couser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
