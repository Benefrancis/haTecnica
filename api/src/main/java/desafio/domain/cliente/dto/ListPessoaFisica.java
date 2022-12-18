package desafio.domain.cliente.dto;

import desafio.domain.cliente.PessoaFisica;
import desafio.domain.cliente.Telefone;
import desafio.domain.endereco.Endereco;

import java.time.LocalDate;

public record ListPessoaFisica(Long id,  String nome, LocalDate nascimento, Telefone telefone,
                               Endereco endereco) {
    public ListPessoaFisica(PessoaFisica cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getNascimento(), cliente.getTelefone(),
                cliente.getEndereco());
    }
}

