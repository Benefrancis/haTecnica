package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.PessoaFisica;
import desafio.domain.cliente.Telefone;
import desafio.domain.endereco.Endereco;

import java.time.LocalDate;

public record ListPessoaFisica(Long id,  String nome, Long tipo, LocalDate nascimento, Telefone telefone,
                               Endereco endereco) {
    public ListPessoaFisica(PessoaFisica cliente) {
        this(cliente.getId(), cliente.getNome(), 1l, cliente.getNascimento(), cliente.getTelefone(),
                cliente.getEndereco());
    }
}
