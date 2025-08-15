package com.enyoi.products.repository;

import com.enyoi.products.entity.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Products, String> {

    Flux<Products> findAllById(Flux<String> ids);





}
