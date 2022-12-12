package desafio.model.equipamento;

import desafio.model.cliente.Cliente;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("2")
public class Mobile extends Equipamento {
    public Mobile(Cliente cliente) {
        super(cliente, TipoEquipamento.MOBILE);
    }

    public Mobile(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.MOBILE);
    }

    public Mobile() {
        super(TipoEquipamento.MOBILE);
    }

    @Override
    public String toString() {
        String sb = "Mobile{" + super.toString() +
                '}';
        return sb;
    }
}
