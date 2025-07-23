package com.foodorders.foodorders.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodorders.foodorders.domain.model.Cliente;

public interface JpaClienteRepository extends JpaRepository<Cliente, Long>{

}
