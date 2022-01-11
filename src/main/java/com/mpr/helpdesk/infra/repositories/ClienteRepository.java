package com.mpr.helpdesk.infra.repositories;

import com.mpr.helpdesk.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
