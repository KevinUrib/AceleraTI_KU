package com.foodorders.foodorders.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodorders.foodorders.application.dto.RepartidorDTO;
import com.foodorders.foodorders.application.usecase.RepartidorUseCase;
import com.foodorders.foodorders.domain.model.Repartidor;

@RestController
@RequestMapping("/api/v1/repartidores")
public class RepartidorController {

    public final RepartidorUseCase repartidorUseCase;

    public RepartidorController(RepartidorUseCase repartidorUseCase){
        this.repartidorUseCase = repartidorUseCase;
    }

    //POST /api/v1/repartidores
    @PostMapping
    public ResponseEntity<Repartidor> crearRepartidor(@RequestBody RepartidorDTO repartidorDTO){
        try {
            Repartidor repartidor = repartidorUseCase.repartidorCreado(repartidorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(repartidor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
