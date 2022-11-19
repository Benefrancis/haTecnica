package br.com.fiap.shift.desafio.model;

import java.time.LocalDateTime;

public class Orcamento extends Servico {
    public Orcamento(Equipamento equipamento, double valor) {
        super(TipoServico.ORCAMENTO, equipamento, valor);
    }

    public Orcamento(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor) {
        super(id, TipoServico.ORCAMENTO, descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Orcamento{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
