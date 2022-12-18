package desafio.domain.equipamento;

import desafio.domain.cliente.Cliente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Computador extends Equipamento {



    public Computador(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie);
    }

    public Computador() {
        super();
    }


}
