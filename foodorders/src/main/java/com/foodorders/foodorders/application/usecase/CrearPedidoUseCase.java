package com.foodorders.foodorders.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodorders.foodorders.domain.model.*;
import com.foodorders.foodorders.application.dto.CrearPedidoDTO;
import com.foodorders.foodorders.application.dto.ProductoPedidoDTO;
import com.foodorders.foodorders.domain.repository.*;

@Service
public class CrearPedidoUseCase {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final RepartidorRepository repartidorRepository;
    private final ProductoRepository productoRepository;

    public CrearPedidoUseCase(PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            RepartidorRepository repartidorRepository,
            ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.repartidorRepository = repartidorRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public Pedido ejecutar(CrearPedidoDTO crearPedidoDTO) {
        Cliente cliente = clienteRepository.buscarClientePorId(crearPedidoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Repartidor repartidor = repartidorRepository.buscarRepartidorPorId(crearPedidoDTO.getRepartidorId())
                .orElseThrow(() -> new RuntimeException("Repartidor no encontrado"));

        List<PedidoDetalle> detalles = new ArrayList<>();

        for (ProductoPedidoDTO prodDto : crearPedidoDTO.getProductos()) {
            Producto producto = productoRepository.buscarProductoPorId(prodDto.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + prodDto.getProductoId()));

            PedidoDetalle detalle = PedidoDetalle.builder()
                    .producto(producto)
                    .cantidad(prodDto.getCantidad())
                    .precioUnitario(producto.getPrecio())
                    .build();

            detalles.add(detalle);
        }

        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .repartidor(repartidor)
                .fecha(LocalDateTime.now())
                .estado(EstadoPedido.RECIBIDO)
                .detalles(detalles)
                .build();

        detalles.forEach(detalle -> detalle.setPedido(pedido));
        return pedidoRepository.guardarPedido(pedido);
    }

}
