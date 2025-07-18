package com.uaimarket.couser.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;


    public User () {
    }

    public User (long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }


    public long getId () {
        return id;
    }

    public User setId (long id) {
        this.id = id;
        return this;
    }

    public String getName () {
        return name;
    }

    public User setName (String name) {
        this.name = name;
        return this;
    }

    public String getEmail () {
        return email;
    }

    public User setEmail (String email) {
        this.email = email;
        return this;
    }

    public String getPhone () {
        return phone;
    }

    public User setPhone (String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword () {
        return password;
    }

    public User setPassword (String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(id);
    }


}
