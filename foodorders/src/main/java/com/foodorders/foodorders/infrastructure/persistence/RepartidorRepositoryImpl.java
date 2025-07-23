package com.foodorders.foodorders.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import com.foodorders.foodorders.domain.model.Repartidor;
import com.foodorders.foodorders.domain.repository.RepartidorRepository;

public class RepartidorRepositoryImpl implements RepartidorRepository{

    private final JpaRepartidorRepository jpaRepartidorRepository;

    public RepartidorRepositoryImpl(JpaRepartidorRepository jpaRepartidorRepository) {
        this.jpaRepartidorRepository = jpaRepartidorRepository;
    }

    @Override
    public Repartidor guardaRepartidor(Repartidor repartidor) {
        return jpaRepartidorRepository.save(repartidor);
    }

    @Override
    public Optional<Repartidor> buscarRepartidorPorId(Long id) {
        return jpaRepartidorRepository.findById(id);
    }

    @Override
    public List<Repartidor> listarRepartidores() {
        return jpaRepartidorRepository.findAll();
    }

    @Override
    public void eliminarRepartidor(Long id) {
        jpaRepartidorRepository.deleteById(id);
    }

}
