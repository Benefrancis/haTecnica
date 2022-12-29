package desafio.domain.cliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.Cliente;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
