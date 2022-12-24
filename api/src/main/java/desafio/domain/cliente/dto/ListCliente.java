package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import desafio.domain.endereco.dto.PutEndereco;

import java.time.LocalDate;

public record ListCliente(
        Long id,
        String nome,
        LocalDate nascimento,
        PutTipoCliente tipo,
        PutTelefone telefone

) {
    public ListCliente(Cliente c) {

        this(
                c.getId(),
                c.getNome(),
                c.getNascimento(),
                (c.getTipo() != null) ? new PutTipoCliente(c.getTipo()) : null,
                (c.getTelefone() != null) ? new PutTelefone(c.getTelefone()) : null

        );
    }
}
