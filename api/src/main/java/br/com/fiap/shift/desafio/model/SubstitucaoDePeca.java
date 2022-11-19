package br.com.fiap.shift.desafio.model;

import java.time.LocalDateTime;

public class SubstitucaoDePeca extends Servico {

    private String nomePecaSubstituida;

    public SubstitucaoDePeca(Equipamento equipamento, double valor, String nomePecaSubstituida) {
        super(TipoServico.SUBSTITUICAO_DE_PECA, equipamento, valor);
        this.nomePecaSubstituida = nomePecaSubstituida;
    }

    public SubstitucaoDePeca(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor, String nomePecaSubstituida) {
        super(id, TipoServico.SUBSTITUICAO_DE_PECA, descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
        this.nomePecaSubstituida = nomePecaSubstituida;
    }

    public String getNomePecaSubstituida() {
        return nomePecaSubstituida;
    }

    public SubstitucaoDePeca setNomePecaSubstituida(String nomePecaSubstituida) {
        this.nomePecaSubstituida = nomePecaSubstituida;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SubstitucaoDePeca{");
        sb.append("nomePecaSubstituida='").append(nomePecaSubstituida).append('\'');
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
