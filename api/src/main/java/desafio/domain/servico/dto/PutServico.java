package desafio.domain.servico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.equipamento.dto.PutEquipamento;
import desafio.domain.servico.Servico;

import java.time.LocalDateTime;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutServico(

        Long id,

        String descricao,

        double valor,

        PutTipoServico tipo,

        LocalDateTime dataAutorizacao,

        LocalDateTime dataInicio,

        LocalDateTime dataConclusao,

        PutEquipamento equipamento

) {

    public PutServico(Servico s) {
        this(
                s.getId(),
                s.getDescricao(),
                s.getValor(),
                new PutTipoServico(s.getTipo()),
                s.getDataAutorizacao(),
                s.getDataInicio(),
                s.getDataConclusao(),

                new PutEquipamento(s.getEquipamento())

        );
    }
}
