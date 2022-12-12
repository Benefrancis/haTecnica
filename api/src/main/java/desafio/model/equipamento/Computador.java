package desafio.model.equipamento;

import desafio.model.cliente.Cliente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Computador extends Equipamento {
    public Computador(Cliente cliente) {
        super(cliente, TipoEquipamento.COMPUTADOR);
    }

    public Computador(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.COMPUTADOR);
    }

    public Computador() {
        super(TipoEquipamento.COMPUTADOR);
    }

    @Override
    public String toString() {
        String sb = "Computador{" + super.toString() +
                '}';
        return sb;
    }
}
