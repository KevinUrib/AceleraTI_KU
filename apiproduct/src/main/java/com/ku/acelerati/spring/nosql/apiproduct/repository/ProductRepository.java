package com.ku.acelerati.spring.nosql.apiproduct.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ku.acelerati.spring.nosql.apiproduct.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
