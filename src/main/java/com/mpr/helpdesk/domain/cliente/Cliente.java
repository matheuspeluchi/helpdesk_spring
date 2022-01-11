package com.mpr.helpdesk.domain.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mpr.helpdesk.domain.chamado.Chamado;
import com.mpr.helpdesk.domain.perfil.Perfil;
import com.mpr.helpdesk.domain.pessoa.Pessoa;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clientes")
public class Cliente extends Pessoa {

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();


    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);

    }

    public List<Chamado> getChamados(){
        return chamados;
    }

    public void setChamados(List<Chamado> chamados){
        this.chamados = chamados;
    }
}
