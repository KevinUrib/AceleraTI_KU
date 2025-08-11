package com.foodorders.foodorders.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodorders.foodorders.application.dto.ClienteDTO;
import com.foodorders.foodorders.domain.model.Cliente;
import com.foodorders.foodorders.domain.repository.ClienteRepository;

@Service
public class ClienteUseCase {

    private final ClienteRepository clienteRepository;

    public ClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

   @Transactional
    public Cliente clienteCreado(ClienteDTO crearClienteDTO) {
        Cliente cliente;
        if (crearClienteDTO.getId() != null) {
            // Si el ID existe, busca el cliente para actualizarlo
            cliente = clienteRepository.buscarClientePorId(crearClienteDTO.getId())
                    .orElse(new Cliente());
        } else {
            // Si no hay ID, crea un nuevo cliente
            cliente = new Cliente();
        }
        cliente.setNombre(crearClienteDTO.getNombre());
        cliente.setEmail(crearClienteDTO.getEmail());
        cliente.setDireccion(crearClienteDTO.getDireccion());
        cliente.setTelefono(crearClienteDTO.getTelefono());
        return clienteRepository.guardarCliente(cliente);
    }


}
