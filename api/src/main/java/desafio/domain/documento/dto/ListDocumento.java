package desafio.domain.documento.dto;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.documento.Documento;
import desafio.domain.documento.TipoDocumento;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ListDocumento(

        Long id,
        @NotBlank
        String numero,

        TipoDocumento tipo,

        LocalDate emissao,

        LocalDate validade,
        @NotBlank
        Long cliente


) {

    public ListDocumento(Long id, String numero, TipoDocumento tipo, LocalDate emissao, LocalDate validade, Long cliente) {
        this.id = id;
        this.numero = numero;
        this.cliente = cliente;
        this.tipo = tipo;
        this.emissao = emissao;
        this.validade = validade;
    }

    public ListDocumento(Documento dados) {
        this(dados.getId(), dados.getNumero(), dados.getTipo(), dados.getEmissao(), dados.getValidade(),dados.getCliente().getId());
    }

}
