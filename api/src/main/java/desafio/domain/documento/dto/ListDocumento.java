package desafio.domain.documento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.documento.Documento;
import desafio.domain.documento.TipoDocumento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ListDocumento(

        Long id,
        @NotBlank
        String numero,

        @NotNull
        @Valid
        TipoDocumento tipo,

        LocalDate emissao,

        LocalDate validade,

        @NotBlank
        Long cliente


) {

    public ListDocumento(Documento dados) {
        this(
                dados.getId(),
                dados.getNumero(),
                dados.getTipo(),
                dados.getEmissao(),
                dados.getValidade(),
                dados.getCliente().getId());
    }

}
