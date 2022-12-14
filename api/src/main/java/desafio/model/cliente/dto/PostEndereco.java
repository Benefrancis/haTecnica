package desafio.model.cliente.dto;

import desafio.model.cliente.CEP;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotNull
        CEP cep,

        @NotNull
        @Valid
        PutCidade cidade

) {

    public PostEndereco(@NotBlank
                        String logradouro, @NotBlank
                        String numero, String complemento, @NotBlank
                        String bairro, @NotNull
                        CEP cep, @NotNull
                        @Valid
                        PutCidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
}
