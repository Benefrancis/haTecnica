package desafio.domain.servico;

import desafio.domain.equipamento.Equipamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("3")
public class SubstitucaoDePeca extends Servico {

    private String peca;


    public SubstitucaoDePeca(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor, String peca) {
        super(id,  descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
        this.peca = peca;
    }

    public SubstitucaoDePeca() {
        super();
    }

    public String getPeca() {
        return peca;
    }

    public SubstitucaoDePeca setPeca(String nomePecaSubstituida) {
        this.peca = nomePecaSubstituida;
        return this;
    }


    @Override
    public String toString() {
        String sb = "SubstituicaoDePeca{" + "nomePecaSubstituida='" + peca + '\'' +
                super.toString() +
                '}';
        return sb;
    }
}
