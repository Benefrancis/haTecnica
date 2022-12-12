package desafio.model.servico;

import desafio.model.equipamento.Equipamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("3")
public class SubstitucaoDePeca extends Servico {

    private String nomePecaSubstituida;

    public SubstitucaoDePeca(Equipamento equipamento, double valor, String nomePecaSubstituida) {
        super(TipoServico.SUBSTITUICAO_DE_PECA, equipamento, valor);
        this.nomePecaSubstituida = nomePecaSubstituida;
    }

    public SubstitucaoDePeca(Long id, Equipamento equipamento, double valor, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, String nomePecaSubstituida) {
        super(id, TipoServico.SUBSTITUICAO_DE_PECA, descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
        this.nomePecaSubstituida = nomePecaSubstituida;
    }

    public SubstitucaoDePeca() {
        super(TipoServico.SUBSTITUICAO_DE_PECA);
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
        String sb = "SubstitucaoDePeca{" + "nomePecaSubstituida='" + nomePecaSubstituida + '\'' +
                super.toString() +
                '}';
        return sb;
    }
}
