package desafio.model.cliente.dto;

import desafio.model.cliente.PessoaJuridica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutPessoaJuridica(

        Long id,

        @NotNull
        @Valid
        PutTipoCliente tipo,

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
        this(pj.getId(), new PutTipoCliente(pj.getTipo()), pj.getNome(), pj.getRazaoSocial(), new PutTelefone(pj.getTelefone()), new PutEndereco(pj.getEndereco()));
    }
}
