package desafio.domain.documento.dto;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.documento.Documento;
import desafio.domain.documento.TipoDocumento;

import java.time.LocalDate;

public record PutDocumento(


        Long id,

        String numero,

        TipoDocumento tipo,

        LocalDate emissao,

        LocalDate validade,

        PutCliente cliente


) {

    public PutDocumento(Long id, String numero, TipoDocumento tipo, LocalDate emissao, LocalDate validade, PutCliente cliente) {
        this.id = id;
        this.numero = numero;
        this.cliente = cliente;
        this.tipo = tipo;
        this.emissao = emissao;
        this.validade = validade;
    }

    public PutDocumento(Documento dados) {
        this(dados.getId(), dados.getNumero(), dados.getTipo(), dados.getEmissao(), dados.getValidade(), new PutCliente(dados.getCliente()));
    }
}