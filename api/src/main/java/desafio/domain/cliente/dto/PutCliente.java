package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import desafio.domain.endereco.dto.PutEndereco;

import java.time.LocalDate;

public record PutCliente(

        Long id,


        String nome,

        LocalDate nascimento,


        PutTipoCliente tipo,


        PutTelefone telefone,


        PutEndereco endereco

) {


    public PutCliente(Cliente c) {
        this(
                c.getId(),
                c.getNome(),
                c.getNascimento(),
                new PutTipoCliente(c.getTipo()),
                new PutTelefone(c.getTelefone()),
                new PutEndereco(c.getEndereco())
        );
    }
}
