package desafio.model.cliente;

import desafio.model.cliente.dto.PutCEP;
import jakarta.persistence.*;

@Entity
public class CEP implements Validavel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CEP")
    @SequenceGenerator(name = "SEQ_CEP", sequenceName = "SEQ_CEP", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CEP")
    private Long id;

    private String cep;

    public CEP(String cep) {

        if (validar(cep)) {
            this.cep = cep;
        } else {
            throw new RuntimeException("O CEP " + cep + " é inválido!");
        }
    }


    public CEP(PutCEP dados) {

        this.id = dados.id();

        if (validar(dados.cep())) {
            this.cep = dados.cep();
        } else {
            throw new RuntimeException("O CEP " + dados.cep() + " é inválido!");
        }

    }

    public CEP() {

    }

    public Long getId() {
        return id;
    }

    public CEP setId(Long id) {
        if (validar(cep)) {
            this.cep = cep;
        } else {
            throw new RuntimeException("O CEP " + cep + " é inválido!");
        }
        return this;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public boolean validar(String t) {
        return t.matches("[0-9]{5}-[0-9]{3}");
    }

    @Override
    public String toString() {
        return cep;
    }

    public void atualizarInformacoes(PutCEP dados) {

        if (!dados.cep().equals(null)) {
            this.cep = dados.cep();
        }
    }
}
