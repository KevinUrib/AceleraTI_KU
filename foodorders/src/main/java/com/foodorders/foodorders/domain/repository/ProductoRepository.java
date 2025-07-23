package com.foodorders.foodorders.domain.repository;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Producto;

public interface ProductoRepository {

    Producto guardarProducto(Producto producto);
    Optional<Producto> buscarProductoPorId(Long id);
    List<Producto> listarProductos();
    void eliminarProducto(Long id);
    
}
