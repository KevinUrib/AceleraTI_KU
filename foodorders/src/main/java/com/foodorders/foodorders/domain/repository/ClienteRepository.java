package com.foodorders.foodorders.domain.repository;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Cliente;

public interface ClienteRepository {

    Cliente guardarCliente(Cliente cliente);
    Optional<Cliente> buscarClientePorId(Long id);
    List<Cliente> listarClientes();
    void eliminarCliente(Long id);

}
