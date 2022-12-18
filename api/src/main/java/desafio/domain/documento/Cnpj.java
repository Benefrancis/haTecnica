package desafio.domain.documento;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Cnpj extends Documento {


    public Cnpj() {
        super();
    }
}
