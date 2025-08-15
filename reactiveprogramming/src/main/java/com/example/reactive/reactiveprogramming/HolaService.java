package com.example.reactive.reactiveprogramming;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class HolaService {

    public Mono<String> hola(){
        return Mono.just("Hola asincrono").delayElement(Duration.ofSeconds(3));
    }

    public Mono<String> hola2(){
        return Mono.just("Hola asincrono 2").delayElement(Duration.ofSeconds(3));
    }
}
