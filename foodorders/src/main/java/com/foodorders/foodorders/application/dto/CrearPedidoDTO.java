package com.foodorders.foodorders.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrearPedidoDTO {

    private Long clienteId;
    private Long repartidorId;
    private List<ProductoPedidoDTO> productos;
}
