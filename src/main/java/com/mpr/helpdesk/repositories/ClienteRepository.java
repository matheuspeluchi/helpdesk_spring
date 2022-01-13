package com.mpr.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpr.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
