package desafio.model.cliente.dto;

import desafio.model.cliente.Endereco;
import desafio.model.cliente.PessoaJuridica;
import desafio.model.cliente.Telefone;
import desafio.model.cliente.TipoCliente;

public record ListPessoaJuridica(Long id, TipoCliente tipo, String nome, String razaoSocial, Telefone telefone, Endereco endereco) {
    public ListPessoaJuridica(PessoaJuridica cliente) {
        this(cliente.getId(), cliente.getTipo(), cliente.getNome(), cliente.getRazaoSocial(), cliente.getTelefone(), cliente.getEndereco());
    }
}
