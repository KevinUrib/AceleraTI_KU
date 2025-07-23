package com.foodorders.foodorders.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodorders.foodorders.domain.model.Repartidor;

public interface JpaRepartidorRepository extends JpaRepository<Repartidor, Long> {

}
