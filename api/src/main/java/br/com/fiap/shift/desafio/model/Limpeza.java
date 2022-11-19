package br.com.fiap.shift.desafio.model;

import java.time.LocalDateTime;

public class Limpeza extends Servico {
    public Limpeza(Equipamento equipamento, double valor) {
        super(TipoServico.LIMPEZA, equipamento, valor);
    }

    public Limpeza(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor) {
        super(id, TipoServico.LIMPEZA, descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Limpeza{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
