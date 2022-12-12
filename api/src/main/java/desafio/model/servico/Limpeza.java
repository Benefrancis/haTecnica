package desafio.model.servico;

import desafio.model.equipamento.Equipamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("2")
public class Limpeza extends Servico {
    public Limpeza(Equipamento equipamento, double valor) {
        super(TipoServico.LIMPEZA, equipamento, valor);
    }

    public Limpeza(Long id, Equipamento equipamento, double valor, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao) {
        super(id, TipoServico.LIMPEZA, descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
    }

    public Limpeza() {
        super(TipoServico.LIMPEZA);
    }


    @Override
    public String toString() {
        String sb = "Limpeza{" + super.toString() +
                '}';
        return sb;
    }
}
