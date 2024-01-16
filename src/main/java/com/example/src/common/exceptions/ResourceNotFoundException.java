package com.example.src.common.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    ResourceNotFoundException(String message){
        super(message);
    }
}
