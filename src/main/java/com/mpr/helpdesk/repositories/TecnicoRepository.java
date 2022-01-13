package com.mpr.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpr.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
