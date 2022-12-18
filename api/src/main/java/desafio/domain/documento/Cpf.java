package desafio.domain.documento;

import desafio.domain.cliente.Cliente;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("CPF")
public class Cpf extends Documento {

    public Cpf() {
        super(new TipoDocumento(2l,"CPF"));
    }

    public Cpf(Long id, String numero, Cliente cliente, TipoDocumento tipo, LocalDate emissao, LocalDate validade) {
        super(id, numero, cliente, tipo, emissao, validade);
    }
}
