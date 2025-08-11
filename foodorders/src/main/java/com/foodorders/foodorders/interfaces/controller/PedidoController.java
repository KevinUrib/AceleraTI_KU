package com.foodorders.foodorders.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodorders.foodorders.application.dto.CrearPedidoDTO;
import com.foodorders.foodorders.application.usecase.CrearPedidoUseCase;
import com.foodorders.foodorders.domain.model.Pedido;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final CrearPedidoUseCase crearPedidoUseCase;

    public PedidoController(CrearPedidoUseCase crearPedidoUseCase) {
        this.crearPedidoUseCase = crearPedidoUseCase;
    }

    // POST /api/v1/pedidos
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedidoDTO dto){
        try {
            Pedido pedido = crearPedidoUseCase.ejecutar(dto);
            return new ResponseEntity<>(pedido, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
