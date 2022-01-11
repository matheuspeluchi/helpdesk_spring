package com.mpr.helpdesk.infra.services;

import com.mpr.helpdesk.application.common.exceptions.NotFoundException;
import com.mpr.helpdesk.domain.tecnico.Tecnico;
import com.mpr.helpdesk.infra.repositories.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    private final TecnicoRepository repository;

    public TecnicoService(TecnicoRepository repository) {
        this.repository = repository;
    }

    public Tecnico obterPorId(Integer id) {
        Optional<Tecnico> tecnico = repository.findById(id);

        return tecnico.orElseThrow(() -> new NotFoundException(id.toString(), "tecnico"));
    }

    public List<Tecnico> listar() {
        return repository.findAll();
    }

}
