package desafio.model.cliente.dto;

import desafio.model.cliente.CEP;
import desafio.model.cliente.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutEndereco(


        Long id,

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotNull
        PutCEP cep,

        @NotNull
        @Valid
        PutCidade cidade

) {

    public PutEndereco(Endereco e) {
        this(e.getCep().getId(), e.getLogradouro(), e.getNumero(), e.getComplemento(), e.getBairro(), new PutCEP(e.getCep()), new PutCidade(e.getCidade()));
    }
}
