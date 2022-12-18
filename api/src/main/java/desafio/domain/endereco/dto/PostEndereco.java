package desafio.domain.endereco.dto;

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

        @NotBlank
        String cep,

        @NotNull
        @Valid
        PutCidade cidade

) {

    public PostEndereco(@NotBlank
                        String logradouro,
                        @NotBlank
                        String numero,
                        String complemento,
                        @NotBlank
                        String bairro,
                        @NotBlank
                        String cep,
                        @NotNull
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
