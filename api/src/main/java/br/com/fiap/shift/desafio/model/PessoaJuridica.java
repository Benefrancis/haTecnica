package br.com.fiap.shift.desafio.model;

public class PessoaJuridica extends Cliente {

    private String razaoSocial;

    public PessoaJuridica(Long id, String nome, String razaoSocial) {
        super(id, TipoCliente.PJ, nome);
        this.razaoSocial = razaoSocial;
    }

    public PessoaJuridica(String nome, String razaoSocial) {
        super(TipoCliente.PJ, nome);
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
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
