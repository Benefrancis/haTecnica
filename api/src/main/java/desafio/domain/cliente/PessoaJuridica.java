package desafio.domain.cliente;

import desafio.domain.cliente.dto.PutPessoaJuridica;
import desafio.domain.endereco.Endereco;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class PessoaJuridica extends Cliente {

    private String razaoSocial;


    public PessoaJuridica() {
        super();
    }


    public PessoaJuridica(PutPessoaJuridica dados) {
        super(dados.id(), dados.nome(), new Endereco(dados.endereco()), new Telefone(dados.telefone()));
        this.razaoSocial = dados.razaoSocial();
    }


    public PessoaJuridica(Long id, String nome, String razaoSocial) {
        super(id, nome);
        this.razaoSocial = razaoSocial;
    }

    public PessoaJuridica(String nome, String razaoSocial) {
        super(nome);
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public PessoaJuridica setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }


    public void atualizarInformacoes(PutPessoaJuridica dados) {

        if (!dados.nome().equals(null)) {
            super.setNome(dados.nome());
        }

        if (!dados.razaoSocial().equals(null)) {
            this.razaoSocial = dados.razaoSocial();
        }

        if (!dados.telefone().equals(null)) {
            super.getTelefone().atualizarInformacoes(dados.telefone());
        }
        if (!dados.endereco().equals(null)) {
            super.getEndereco().atualizarInformacoes(dados.endereco());
        }

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PessoaJuridica{");
        sb.append("razaoSocial='").append(razaoSocial).append('\'');
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
