package com.foodorders.foodorders.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Producto;
import com.foodorders.foodorders.domain.repository.ProductoRepository;

public class ProductoRepositoryImpl implements ProductoRepository{

    private final JpaProductoRepository jpaProductoRepository;

    public ProductoRepositoryImpl(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return jpaProductoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarProductoPorId(Long id) {
        return jpaProductoRepository.findById(id);
    }

    @Override
    public List<Producto> listarProductos() {
        return jpaProductoRepository.findAll();
    }

    @Override
    public void eliminarProducto(Long id) {
       jpaProductoRepository.deleteById(id);
    }

}
