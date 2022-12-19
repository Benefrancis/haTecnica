package desafio.domain.documento;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.PessoaFisica;
import desafio.domain.cliente.PessoaJuridica;
import desafio.domain.documento.dto.PutDocumento;
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



    public Cpf(PutDocumento dados) {

        super(new TipoDocumento(1l, "RG"));

        Cliente cli = null;

        var t = dados.cliente().id();

        if (t == 1L) {
            cli = new PessoaFisica();
            cli.setId(dados.cliente().id());
            super.setCliente(cli);
        } else if (t == 2L) {
            cli = new PessoaJuridica();
            cli.setId(dados.cliente().id());
            super.setCliente(cli);
        }

        super.setEmissao(dados.emissao());
        super.setTipo(dados.tipo());
        super.setNumero(dados.numero());
        super.setValidade(dados.validade());

    }
}
