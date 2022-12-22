package desafio.domain.documento.dto;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.documento.Documento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

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