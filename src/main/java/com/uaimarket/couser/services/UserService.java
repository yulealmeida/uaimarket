package com.uaimarket.couser.services;

import com.uaimarket.couser.entities.User;
import com.uaimarket.couser.repositories.UserRepository;
import com.uaimarket.couser.services.exceptions.DatabaseExeption;
import com.uaimarket.couser.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
    return repository.save(obj);
    }

    public void delete(Long id){
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseExeption(e.getMessage());
        }

    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData (User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }



}
