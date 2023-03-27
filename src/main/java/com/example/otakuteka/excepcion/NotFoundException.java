package com.example.otakuteka.excepcion;

public class NotFoundException extends Exception{
    public NotFoundException(String errorMessage){
        super(errorMessage);
    }
}
