package com.foodorders.foodorders.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodorders.foodorders.application.dto.ClienteDTO;
import com.foodorders.foodorders.application.usecase.ClienteUseCase;
import com.foodorders.foodorders.domain.model.Cliente;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteUseCase crearClienteUseCase;

    public ClienteController(ClienteUseCase crearClienteUseCase) {
        this.crearClienteUseCase = crearClienteUseCase;
    }

    // POST /api/v1/clientes
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente cliente = crearClienteUseCase.clienteCreado(clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
