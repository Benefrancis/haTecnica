package br.com.fiap.shift.desafio.model;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {
    private LocalDate nascimento;


    public PessoaFisica(Long id, String nome, LocalDate nascimento) {
        super(id, TipoCliente.PF, nome);
        this.nascimento = nascimento;
    }


    public PessoaFisica(String nome, LocalDate nascimento) {
        super(TipoCliente.PF, nome);
        this.nascimento = nascimento;
    }


    public LocalDate getNascimento() {
        return nascimento;
    }

    public PessoaFisica setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PessoaFisica{");
        sb.append("nascimento=").append(nascimento);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
