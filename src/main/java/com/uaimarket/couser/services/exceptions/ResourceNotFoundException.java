package com.uaimarket.couser.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (Object id) {
        super("Resource not fund. id " + id);
    }
}
