package desafio.domain.equipamento.dto;

import desafio.domain.equipamento.TipoEquipamento;
import jakarta.validation.constraints.NotBlank;

public record PutTipoEquipamento(

        Long id,
        @NotBlank
        String nome
) {


    public PutTipoEquipamento(TipoEquipamento e) {
        this(
                e.getId(),
                e.getNome()
        );
    }

}
