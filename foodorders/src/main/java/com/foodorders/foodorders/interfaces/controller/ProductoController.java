package com.foodorders.foodorders.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodorders.foodorders.application.dto.ProductoDTO;
import com.foodorders.foodorders.application.usecase.ProductoUseCase;
import com.foodorders.foodorders.domain.model.Producto;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoUseCase crearProductoUseCase;

    public ProductoController(ProductoUseCase crearProductoUseCase) {
        this.crearProductoUseCase = crearProductoUseCase;
    }

    // POST /api/v1/productos
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO productoDTO) {
        try {
            Producto producto = crearProductoUseCase.productoCreado(productoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
