package desafio.model.cliente.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostPessoaFisica(


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

        public PostPessoaFisica(@NotNull
                                @Valid
                                PutTipoCliente tipo, @NotBlank
                                String nome,
                                LocalDate nascimento, @NotNull
                                @Valid
                                PutTelefone telefone, @NotNull
                                @Valid
                                PutEndereco endereco) {
                this.tipo = tipo;
                this.nome = nome;
                this.nascimento = nascimento;
                this.telefone = telefone;
                this.endereco = endereco;
        }
}
