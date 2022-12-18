package desafio.domain.documento;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RG")
public class Rg extends Documento {

    public Rg()  {
        super(new TipoDocumento(1l,"RG"));
    }
}
