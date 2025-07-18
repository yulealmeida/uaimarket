package com.uaimarket.couser.resources;


import com.uaimarket.couser.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria","maria@bol.com","999-999","1234567");
        return ResponseEntity.ok().body(u);
    }


}
