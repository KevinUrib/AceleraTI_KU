package com.foodorders.foodorders.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorders.foodorders.domain.model.Pedido;

public interface JpaPedidoRepository extends JpaRepository<Pedido, Long> {


}
