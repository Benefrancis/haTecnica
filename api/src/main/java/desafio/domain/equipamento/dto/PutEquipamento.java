package desafio.domain.equipamento.dto;

import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.equipamento.Equipamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutEquipamento(

        Long id,

        @NotBlank
        String numeroDeSerie,

        @NotNull
        @Valid
        PutTipoEquipamento tipo,

        @NotNull
        @Valid
        PutCliente cliente

) {

    public PutEquipamento(
            Long id,
            @NotBlank
            String numeroDeSerie,
            @NotNull
            @Valid
            PutTipoEquipamento tipo,
            @NotNull
            @Valid
            PutCliente cliente) {
        this.id = id;
        this.numeroDeSerie = numeroDeSerie;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public PutEquipamento(Equipamento e) {
        this(e.getId(), e.getNumeroDeSerie(), new PutTipoEquipamento(e.getTipo()), new PutCliente(e.getCliente()));
    }


}
