package com.foodorders.foodorders.domain.repository;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Repartidor;

public interface RepartidorRepository {

    Repartidor guardaRepartidor(Repartidor repartidor);
    Optional<Repartidor> buscarRepartidorPorId(Long id);
    List<Repartidor> listarRepartidores();
    void eliminarRepartidor(Long id);
}
