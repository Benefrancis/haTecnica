package desafio.domain.equipamento;

import desafio.domain.cliente.Cliente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class VideoGame extends Equipamento {

    public VideoGame(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie );
    }

    public VideoGame() {
        super();
    }


}
