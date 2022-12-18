package desafio.domain.cliente.dto;

import desafio.domain.endereco.dto.PutEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostPessoaJuridica(

        @NotBlank
        String nome,

        @NotBlank
        String razaoSocial,

        @NotNull
        @Valid
        PutTipoCliente tipo,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco
)  {

        public PostPessoaJuridica(@NotBlank
                                  String nome, @NotBlank
                                  String razaoSocial, @NotNull
                                  @Valid
                                  PutTipoCliente tipo, @NotNull
                                  @Valid
                                  PutTelefone telefone, @NotNull
                                  @Valid
                                  PutEndereco endereco) {
                this.nome = nome;
                this.razaoSocial = razaoSocial;
                this.tipo = tipo;
                this.telefone = telefone;
                this.endereco = endereco;
        }
}
