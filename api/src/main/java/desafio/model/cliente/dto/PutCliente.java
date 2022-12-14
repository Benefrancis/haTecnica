package desafio.model.cliente.dto;

import desafio.model.cliente.PessoaFisica;
import desafio.model.cliente.PessoaJuridica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutCliente(

        Long id,

        @NotNull
        @Valid PutTipoCliente tipo,

        @NotBlank
        String nome,

        @NotNull
        @Valid
        PutTelefone telefone,

        @NotNull
        @Valid
        PutEndereco endereco

) {


    public PutCliente(PessoaJuridica pf) {
        this(pf.getId(), new PutTipoCliente(pf.getTipo()), pf.getNome(), new PutTelefone(pf.getTelefone()), new PutEndereco(pf.getEndereco()));
    }

    public PutCliente(PessoaFisica pf) {
        this(pf.getId(), new PutTipoCliente(pf.getTipo()), pf.getNome(), new PutTelefone(pf.getTelefone()), new PutEndereco(pf.getEndereco()));
    }

    public PutCliente(Long id, @NotNull
    @Valid PutTipoCliente tipo, @NotBlank
                      String nome, @NotNull
                      @Valid
                      PutTelefone telefone, @NotNull
                      @Valid
                      PutEndereco endereco) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }


}
