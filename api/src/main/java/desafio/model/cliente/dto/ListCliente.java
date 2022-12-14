package desafio.model.cliente.dto;

import desafio.model.cliente.Cliente;
import desafio.model.cliente.Endereco;
import desafio.model.cliente.Telefone;
import desafio.model.cliente.TipoCliente;

public record ListCliente(Long id, TipoCliente tipo, String nome, Telefone telefone, Endereco endereco) {
    public ListCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getTipo(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco());
    }
}
