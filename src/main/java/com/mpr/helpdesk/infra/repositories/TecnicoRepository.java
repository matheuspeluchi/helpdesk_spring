package com.mpr.helpdesk.infra.repositories;

import com.mpr.helpdesk.domain.tecnico.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {


}
