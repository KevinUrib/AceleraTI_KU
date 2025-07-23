package com.foodorders.foodorders.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Pedido;
import com.foodorders.foodorders.domain.repository.PedidoRepository;

public class PedidoRepositoryImpl implements PedidoRepository{

    private final JpaPedidoRepository jpaPedidoRepository;

    public PedidoRepositoryImpl(JpaPedidoRepository jpaPedidoRepository) {
        this.jpaPedidoRepository = jpaPedidoRepository;
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return jpaPedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return jpaPedidoRepository.findById(id);
    }
        

    @Override
    public List<Pedido> listarPedidos() {
        return jpaPedidoRepository.findAll();
    }

}
