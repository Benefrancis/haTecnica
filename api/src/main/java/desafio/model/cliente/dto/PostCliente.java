package desafio.model.cliente.dto;

import desafio.model.cliente.TipoCliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostCliente(

        @NotNull
        @Valid
        PutTipoCliente tipo,

        @NotBlank
        String nome,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco) {


        public PostCliente(@NotNull
                           @Valid
                           PutTipoCliente tipo, @NotBlank
                           String nome, @NotNull
                           @Valid
                           PutTelefone telefone, @NotNull
                           @Valid
                           PutEndereco endereco) {
                this.tipo = tipo;
                this.nome = nome;
                this.telefone = telefone;
                this.endereco = endereco;
        }
}
