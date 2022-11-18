package br.com.fiap.shift.desafio.model;

import java.time.LocalDate;

public class PessoaJuridica extends Cliente {

    private String razaoSocial;

    public PessoaJuridica() {
        super(TipoCliente.PJ);
    }

    public PessoaJuridica(String razaoSocial) {
        super(TipoCliente.PJ);
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public PessoaJuridica setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PessoaJuridica{");
        sb.append("razaoSocial='").append(razaoSocial).append('\'');
        sb.append("Cliente=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
