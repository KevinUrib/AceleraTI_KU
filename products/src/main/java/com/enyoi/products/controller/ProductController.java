package com.enyoi.products.controller;

import com.enyoi.products.entity.Products;
import com.enyoi.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Mono<Products> saveProduct(@RequestBody Products products){
        return productService.saveProduct(products);
    }

    /*
    @PostMapping(value = "/find/id", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Products> findById(@RequestBody List<String> ids){
        return productService.getProductById(Flux.fromIterable(ids));
    }
    */
    @PostMapping(value = "/get", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Products> getProductsByIds(@RequestBody List<String> ids){
        return productService.getProductById(Flux.fromIterable(ids));
    }

    @GetMapping("/{id}")
    public Mono<Products> getProductById(@PathVariable("id") String id){
        return productService.getProductById(id);
    }


}
