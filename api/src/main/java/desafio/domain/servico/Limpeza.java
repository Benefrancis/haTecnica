package desafio.domain.servico;

import desafio.domain.equipamento.Equipamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("2")
public class Limpeza extends Servico {


    public Limpeza(Long id, Equipamento equipamento, double valor, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao) {
        super(id,  descricao, dataAutorizacao, dataInicio, dataConclusao, equipamento, valor);
    }

    public Limpeza() {
        super();
    }


    @Override
    public String toString() {
        String sb = "Limpeza{" + super.toString() +
                '}';
        return sb;
    }
}
