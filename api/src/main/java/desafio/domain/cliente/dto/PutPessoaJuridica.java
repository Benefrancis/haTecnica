package desafio.domain.cliente.dto;

import desafio.domain.cliente.PessoaJuridica;
import desafio.domain.endereco.dto.PutEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutPessoaJuridica(

        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String razaoSocial,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco

) {


    public PutPessoaJuridica(PessoaJuridica pj) {
        this(pj.getId(), pj.getNome(), pj.getRazaoSocial(), new PutTelefone(pj.getTelefone()), new PutEndereco(pj.getEndereco()));
    }
}
