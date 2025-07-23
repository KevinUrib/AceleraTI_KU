package com.foodorders.foodorders.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorders.foodorders.domain.model.Producto;

public interface JpaProductoRepository extends JpaRepository<Producto, Long>{

}
