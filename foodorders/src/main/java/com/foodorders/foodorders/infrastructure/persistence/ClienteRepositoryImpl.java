package com.foodorders.foodorders.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.foodorders.foodorders.domain.model.Cliente;
import com.foodorders.foodorders.domain.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final JpaClienteRepository jpaClienteRepository;

    public ClienteRepositoryImpl(JpaClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return jpaClienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) {
        return jpaClienteRepository.findById(id);
        }

    @Override
    public List<Cliente> listarClientes() {
        return jpaClienteRepository.findAll();
    }

    @Override
    public void eliminarCliente(Long id) {
        jpaClienteRepository.deleteById(id);
    }

}
