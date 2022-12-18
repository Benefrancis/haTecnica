package desafio.domain.cliente.dto;

import desafio.domain.cliente.PessoaJuridica;
import desafio.domain.cliente.Telefone;
import desafio.domain.endereco.Endereco;

public record ListPessoaJuridica(Long id, String nome, Long tipo, String razaoSocial, Telefone telefone,
                                 Endereco endereco) {
    public ListPessoaJuridica(PessoaJuridica cliente) {
        this(cliente.getId(), cliente.getNome(), 2l, cliente.getRazaoSocial(), cliente.getTelefone(), cliente.getEndereco());
    }
}
