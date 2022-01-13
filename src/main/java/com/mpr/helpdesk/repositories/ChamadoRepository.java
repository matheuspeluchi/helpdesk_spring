package com.mpr.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpr.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
