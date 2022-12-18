package desafio.domain.documento;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Rg extends Documento {

    public Rg() {
        super();
    }
}
