package desafio.domain.documento;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Cpf extends Documento {

    public Cpf() {
        super();
    }
}
