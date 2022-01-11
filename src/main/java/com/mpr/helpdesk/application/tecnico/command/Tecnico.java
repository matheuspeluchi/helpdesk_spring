package com.mpr.helpdesk.application.tecnico.command;


import com.mpr.helpdesk.domain.tecnico.NovoTecnico;
import com.mpr.helpdesk.application.tecnico.TecnicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/tecnicos")
public class Tecnico {

    @Autowired
    private NovoTecnico novoTecnicoUseCase;

    @PostMapping
    public ResponseEntity<TecnicoDTO> novoTecnico(@Valid @RequestBody TecnicoDTO dto){
        TecnicoDTO obj = novoTecnicoUseCase.novoTecnico(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
