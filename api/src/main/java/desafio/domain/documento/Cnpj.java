package desafio.domain.documento;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CNPJ")
public class Cnpj extends Documento {


    public Cnpj() {
        super(new TipoDocumento(3l,"CNPJ"));
    }
}
