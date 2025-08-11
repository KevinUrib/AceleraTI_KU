package com.foodorders.foodorders.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodorders.foodorders.application.dto.ProductoDTO;
import com.foodorders.foodorders.domain.model.Producto;
import com.foodorders.foodorders.domain.repository.ProductoRepository;

@Service
public class ProductoUseCase {

    private final ProductoRepository productoRepository;

    public ProductoUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional
    public Producto productoCreado(ProductoDTO crearProductoDTO) {
        Producto producto;
        if (crearProductoDTO.getId() != null) {
            // Si el ID existe, busca el producto para actualizarlo
            producto = productoRepository.buscarProductoPorId(crearProductoDTO.getId())
                    .orElse(new Producto());
        } else {
            // Si no hay ID, crea un nuevo producto
            producto = new Producto();
        }
        producto.setNombre(crearProductoDTO.getNombre());
        producto.setPrecio(crearProductoDTO.getPrecio());
        return productoRepository.guardarProducto(producto);
    }

}
