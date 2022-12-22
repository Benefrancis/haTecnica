package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import desafio.domain.endereco.dto.PutEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PutCliente(

        Long id,

        @NotBlank
        String nome,

        LocalDate nascimento,

        @NotNull
        @Valid
        PutTipoCliente tipo,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco

) {


    public PutCliente(Cliente c) {
        this(
                c.getId(),
                c.getNome(),
                c.getNascimento(),
                new PutTipoCliente(c.getTipo()),
                new PutTelefone(c.getTelefone()),
                new PutEndereco(c.getEndereco())
        );
    }
}
