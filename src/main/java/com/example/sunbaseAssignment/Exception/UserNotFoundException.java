package com.example.sunbaseAssignment.Exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){}
    public UserNotFoundException(String message){
        super(message);
    }
}
