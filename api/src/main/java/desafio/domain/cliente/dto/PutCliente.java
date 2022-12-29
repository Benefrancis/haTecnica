package desafio.domain.cliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
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
                c != null && c.getId() != null ? c.getId() : null,
                c != null && c.getNome() != null ? c.getNome() : null,
                c != null && c.getEmail() != null ? c.getEmail() : null,
                c != null && c.getNascimento() != null ? c.getNascimento() : null,
                c != null && c.getTipo() != null ? new PutTipoCliente(c.getTipo()) : null,
                c != null && c.getTelefone() != null ? new PutTelefone(c.getTelefone()) : null
        );
    }
}
