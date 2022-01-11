package com.mpr.helpdesk.infra.repositories;

import com.mpr.helpdesk.domain.chamado.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
