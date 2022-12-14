package desafio.model.cliente.dto;

import desafio.model.cliente.PessoaFisica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PutPessoaFisica(


        Long id,

        @NotNull
        @Valid
        PutTipoCliente tipo,

        @NotBlank
        String nome,

        LocalDate nascimento,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco

) {

    public PutPessoaFisica(PessoaFisica pf) {
        this(pf.getId(), new PutTipoCliente(pf.getTipo()), pf.getNome(), pf.getNascimento(), new PutTelefone(pf.getTelefone()), new PutEndereco(pf.getEndereco()));
    }
}
