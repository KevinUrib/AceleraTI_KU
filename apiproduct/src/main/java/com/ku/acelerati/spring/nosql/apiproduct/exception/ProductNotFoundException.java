package com.ku.acelerati.spring.nosql.apiproduct.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
