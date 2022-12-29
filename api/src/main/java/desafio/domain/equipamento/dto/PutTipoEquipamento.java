package desafio.domain.equipamento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.equipamento.TipoEquipamento;
import jakarta.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutTipoEquipamento(

        Long id,
        @NotBlank
        String nome
) {


    public PutTipoEquipamento(TipoEquipamento e) {

        this(
                e != null && e.getId() != null ? e.getId() : null,
                e != null && e.getNome() != null ? e.getNome() : null
        );


    }

}
