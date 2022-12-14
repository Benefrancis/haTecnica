package desafio.model.cliente.dto;

import desafio.model.cliente.Endereco;
import desafio.model.cliente.PessoaFisica;
import desafio.model.cliente.Telefone;
import desafio.model.cliente.TipoCliente;

import java.time.LocalDate;

public record ListPessoaFisica(Long id, TipoCliente tipo, String nome, LocalDate nascimento, Telefone telefone,Endereco endereco) {
    public ListPessoaFisica(PessoaFisica cliente) {
        this(cliente.getId(), cliente.getTipo(), cliente.getNome(), cliente.getNascimento(), cliente.getTelefone(), cliente.getEndereco());
    }
}

