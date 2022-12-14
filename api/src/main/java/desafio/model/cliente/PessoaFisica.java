package desafio.model.cliente;

import desafio.model.cliente.dto.PutPessoaFisica;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@DiscriminatorValue("1")
public class PessoaFisica extends Cliente {
    private LocalDate nascimento;

    public PessoaFisica(Long id, String nome, LocalDate nascimento) {
        super(id, new TipoCliente(1l, "PessoaFísica", "PF"), nome);
        this.nascimento = nascimento;
    }

    public PessoaFisica(PutPessoaFisica dados) {
        super(dados.id(), new TipoCliente(dados.tipo()), dados.nome(), new Endereco(dados.endereco()), new Telefone(dados.telefone()));
        this.nascimento = dados.nascimento();
    }

    public PessoaFisica(String nome, LocalDate nascimento) {
        super(new TipoCliente(1l, "PessoaFísica", "PF"), nome);
        this.nascimento = nascimento;
    }

    public PessoaFisica() {
        super(new TipoCliente(1l, "PessoaFísica", "PF"));
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public PessoaFisica setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }


    public void atualizarInformacoes(PutPessoaFisica dados) {

        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }

        if (dados.tipo() != null) {
            super.getTipo().atualizarInformacoes(dados.tipo());
        }

        if (dados.telefone() != null) {
            super.getTelefone().atualizarInformacoes(dados.telefone());
        }
        if (dados.endereco() != null) {
            super.getEndereco().atualizarInformacoes(dados.endereco());
        }

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PessoaFisica{");
        sb.append("nascimento=").append(nascimento);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
