package desafio.domain.cliente.dto;

import desafio.domain.cliente.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PutCliente(

        Long id,

        @NotEmpty(message = "{nome.obrigatorio}")
        String nome,


        @NotEmpty(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}", regexp = "^[_A-Za-z0-9-\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        String email,

        @Past(message = "A data de nascimento deve ser anterior à data atual")
        LocalDate nascimento,

        @NotNull(message = "{tipoCliente.obrigatorio}")
        @Valid
        PutTipoCliente tipo,

        @NotNull(message = "{telefone.obrigatorio}")
        @Valid
        PutTelefone telefone


) {


    public PutCliente(Cliente c) {
        this(
                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getNascimento(),
                new PutTipoCliente(c.getTipo()),
                new PutTelefone(c.getTelefone())

        );
    }
}
