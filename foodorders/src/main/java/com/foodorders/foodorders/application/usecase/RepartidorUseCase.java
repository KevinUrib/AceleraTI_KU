package com.foodorders.foodorders.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodorders.foodorders.application.dto.RepartidorDTO;
import com.foodorders.foodorders.domain.model.Repartidor;
import com.foodorders.foodorders.domain.repository.RepartidorRepository;

@Service
public class RepartidorUseCase {

    private final RepartidorRepository repartidorRepository;

    public RepartidorUseCase(RepartidorRepository repartidorRepository){
        this.repartidorRepository = repartidorRepository;
    }

    @Transactional
    public Repartidor repartidorCreado(RepartidorDTO crearRepartidorDTO){
        Repartidor repartidor;
        if(crearRepartidorDTO.getId() != null){
            repartidor = repartidorRepository.buscarRepartidorPorId(crearRepartidorDTO.getId())
            .orElse(new Repartidor());
        } else {
            repartidor = new Repartidor();
        }
        repartidor.setNombre(crearRepartidorDTO.getNombre());
        repartidor.setTelefono(crearRepartidorDTO.getTelefono());
        return repartidorRepository.guardaRepartidor(repartidor);
    }
}
