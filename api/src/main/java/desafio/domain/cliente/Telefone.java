package desafio.domain.cliente;

import desafio.domain.cliente.dto.PutTelefone;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Telefone {

    private String ddi;
    @Column(name = "ddd", nullable = false)
    private String ddd;
    @Column(name = "numero", nullable = false)
    private String numero;


    public Telefone() {
    }

    public Telefone(PutTelefone dados) {
        this.ddi = dados.ddi();
        this.ddd = dados.ddd();
        this.numero = dados.numero();
    }

    public Telefone(String ddi, String ddd, String numero) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdi() {
        return ddi;
    }

    public Telefone setDdi(String ddi) {
        this.ddi = ddi;
        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public Telefone setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Telefone setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public void atualizarInformacoes(PutTelefone dados) {
        if (!dados.ddi().equals(null)) {
            this.ddi = dados.ddi();
        }
        if (!dados.ddd().equals(null)) {
            this.ddd = dados.ddd();
        }

        if (!dados.numero().equals(null)) {
            this.numero = dados.numero();
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Telefone{");
        sb.append(", ddi='").append(ddi).append('\'');
        sb.append(", ddd='").append(ddd).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
