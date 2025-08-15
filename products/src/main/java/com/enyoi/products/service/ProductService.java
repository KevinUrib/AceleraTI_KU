package com.enyoi.products.service;

import com.enyoi.products.entity.Products;
import com.enyoi.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<Products> saveProduct(Products products){
        return productRepository.save(products);
    }

    public Flux<Products> getProductById(Flux<String> idFlux){
        return productRepository.findAllById(idFlux);
    }

    public Mono<Products> getProductById(String id){
        return productRepository.findById(id);
    }


}
