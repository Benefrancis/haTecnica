package desafio.domain.equipamento.dto;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.equipamento.Equipamento;

public record ListEquipamento(

        Long id,

        String numeroDeSerie,

        PutTipoEquipamento tipo,

        PutCliente cliente

) {

    public ListEquipamento(Long id, String numeroDeSerie, PutTipoEquipamento tipo, PutCliente cliente) {
        this.id = id;
        this.numeroDeSerie = numeroDeSerie;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public ListEquipamento(Equipamento e) {
        this(e.getId(), e.getNumeroDeSerie(), new PutTipoEquipamento(e.getTipo()), new PutCliente(e.getCliente()));
    }

}
