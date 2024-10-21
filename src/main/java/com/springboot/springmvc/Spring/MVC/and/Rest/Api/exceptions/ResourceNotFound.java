package com.springboot.springmvc.Spring.MVC.and.Rest.Api.exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
