package desafio.domain.documento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.documento.Documento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jshell.Snippet;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutDocumento(

        Long id,
        @NotBlank
        String numero,

        @NotNull
        @Valid
        PutTipoDocumento tipo,

        LocalDate emissao,

        LocalDate validade,

        PutCliente cliente


) {



    public PutDocumento(Documento dados) {
        this(
                dados.getId(),
                dados.getNumero(),
                new PutTipoDocumento(dados.getTipo()),
                dados.getEmissao(),
                dados.getValidade(),
                new PutCliente(dados.getCliente())
        );
    }


}