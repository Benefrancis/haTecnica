package desafio.model.cliente;

import java.util.StringJoiner;

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
        return new StringJoiner(", ", PessoaJuridica.class.getSimpleName() + "[", "]")
                .add("razaoSocial='" + razaoSocial + "'")
                .add(super.toString())
                .toString();
    }
}
