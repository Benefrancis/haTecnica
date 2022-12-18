package desafio.domain.equipamento;

import desafio.domain.cliente.Cliente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Mobile extends Equipamento {



    public Mobile(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie);
    }

    public Mobile() {
        super();
    }


}
