package desafio.model.servico;

import desafio.model.equipamento.Equipamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
@Entity
@DiscriminatorValue("1")
public class Orcamento extends Servico {
    public Orcamento(Equipamento equipamento, double valor) {
        super(TipoServico.ORCAMENTO, equipamento, valor);
    }

    public Orcamento(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor) {
        super(id, TipoServico.ORCAMENTO, descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
    }

    public Orcamento() {
        super(TipoServico.ORCAMENTO);
    }


    @Override
    public String toString() {
        String sb = "Orcamento{" + super.toString() +
                '}';
        return sb;
    }
}
