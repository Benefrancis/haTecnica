package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import desafio.domain.endereco.dto.PutEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutCliente(

        Long id,

        @NotBlank
        String nome,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco,

        @NotNull
        @Valid
        PutTipoCliente tipo

) {

    public PutCliente(Cliente c) {
        this(c.getId(), c.getNome(), new PutTelefone(c.getTelefone()), new PutEndereco(c.getEndereco()), new PutTipoCliente(c.getTipo()));
    }
}
