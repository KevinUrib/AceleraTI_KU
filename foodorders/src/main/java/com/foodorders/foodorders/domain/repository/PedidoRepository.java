package com.foodorders.foodorders.domain.repository;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Pedido;

public interface PedidoRepository {

    Pedido guardarPedido(Pedido pedido);
    Optional<Pedido> buscarPedidoPorId(Long id);
    List<Pedido> listarPedidos();
}
