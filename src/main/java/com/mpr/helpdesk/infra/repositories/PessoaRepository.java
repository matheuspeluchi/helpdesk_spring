package com.mpr.helpdesk.infra.repositories;

import com.mpr.helpdesk.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findPessoaByCpf(String cpf);
    Optional<Pessoa> findPessoaByEmail(String email);


}
