package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import desafio.domain.endereco.dto.PutEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PutCliente(

        Long id,


        String nome,



        @Email(message = "{email.invalido}")
        String email,


        LocalDate nascimento,


        PutTipoCliente tipo,


        PutTelefone telefone,


        PutEndereco endereco

) {


    public PutCliente(Cliente c) {
        this(
                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getNascimento(),
                new PutTipoCliente(c.getTipo()),
                new PutTelefone(c.getTelefone()),
                new PutEndereco(c.getEndereco())
        );
    }
}
