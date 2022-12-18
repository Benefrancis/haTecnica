package desafio.domain.servico;

import desafio.domain.equipamento.Equipamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
@Entity
@DiscriminatorValue("1")
public class Orcamento extends Servico {


    public Orcamento(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor) {
        super(id,  descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
    }

    public Orcamento() {
        super();
    }


    @Override
    public String toString() {
        String sb = "Orcamento{" + super.toString() +
                '}';
        return sb;
    }
}
