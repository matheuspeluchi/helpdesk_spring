package com.mpr.helpdesk.application.tecnico.query;

import com.mpr.helpdesk.application.tecnico.TecnicoDTO;
import com.mpr.helpdesk.infra.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "tecnicos")
public class GetTecnico {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> obterPorId(@PathVariable Integer id){

        com.mpr.helpdesk.domain.tecnico.Tecnico obj = service.obterPorId(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));

    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> listar(){
        List<com.mpr.helpdesk.domain.tecnico.Tecnico> lista = service.listar();
        List<TecnicoDTO> listaDto = lista.stream().map(TecnicoDTO::new).collect(Collectors.toList());

        return  ResponseEntity.ok().body(listaDto);
    }
}
