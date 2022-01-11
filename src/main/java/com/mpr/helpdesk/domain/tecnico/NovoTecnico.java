package com.mpr.helpdesk.domain.tecnico;

import com.mpr.helpdesk.application.common.exceptions.NegocioException;
import com.mpr.helpdesk.application.tecnico.TecnicoDTO;
import com.mpr.helpdesk.domain.pessoa.Pessoa;
import com.mpr.helpdesk.infra.repositories.PessoaRepository;
import com.mpr.helpdesk.infra.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class NovoTecnico {

    private final TecnicoRepository repository;
    private final PessoaRepository pessoaRepository;

    public NovoTecnico(TecnicoRepository repository, PessoaRepository pessoaRepository) {
        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    public TecnicoDTO novoTecnico(TecnicoDTO tecnico) {
        tecnico.setId(null);
        validarPorCpfEEmail(tecnico);
        Tecnico novoTecnico = new Tecnico(tecnico);
        Tecnico tecnicoSalvo = repository.save(novoTecnico);

        return new TecnicoDTO(tecnicoSalvo);
    }

    private void validarPorCpfEEmail(TecnicoDTO tecnico) {
        Optional<Pessoa> pessoa = pessoaRepository.findPessoaByCpf(tecnico.getCpf());
        if(pessoa.isPresent() && !Objects.equals(pessoa.get().getId(), tecnico.getId())){
            throw  new NegocioException("O CPF informado já esta registrado no sistema", tecnico.getCpf());
        }

        pessoa = pessoaRepository.findPessoaByEmail(tecnico.getEmail());

        if(pessoa.isPresent() && !Objects.equals(pessoa.get().getId(), tecnico.getId())){
            throw  new NegocioException("O email informado já esta registrado no sistema", tecnico.getEmail());
        }

    }
}
