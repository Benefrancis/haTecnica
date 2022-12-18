package desafio.domain.cliente.dto;

import desafio.domain.cliente.PessoaFisica;
import desafio.domain.endereco.dto.PutEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PutPessoaFisica(


        Long id,

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
        this(pf.getId(), pf.getNome(), pf.getNascimento(), new PutTelefone(pf.getTelefone()), new PutEndereco(pf.getEndereco()));
    }
}
