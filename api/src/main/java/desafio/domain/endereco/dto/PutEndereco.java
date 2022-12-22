package desafio.domain.endereco.dto;

import desafio.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PutEndereco(

        Long id,

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
        @NotBlank
        String cep,

        @NotNull
        @Valid
        PutCidade cidade

) {

    public PutEndereco(Endereco e) {
        this(
                e.getId(),
                e.getLogradouro(),
                e.getNumero(),
                e.getComplemento(),
                e.getBairro(),
                e.getCep(),
                new PutCidade(e.getCidade())
        );
    }
}
