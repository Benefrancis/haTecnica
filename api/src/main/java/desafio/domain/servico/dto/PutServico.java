package desafio.domain.servico.dto;

import desafio.domain.equipamento.dto.PutEquipamento;
import desafio.domain.servico.Servico;

import java.time.LocalDateTime;

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
