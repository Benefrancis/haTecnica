package desafio.domain.cliente;

import desafio.domain.cliente.dto.PutPessoaFisica;
import desafio.domain.endereco.Endereco;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("1")
public class PessoaFisica extends Cliente {
    private LocalDate nascimento;


    public PessoaFisica(Long id, String nome, LocalDate nascimento) {
        super(id, nome);
        this.nascimento = nascimento;
        super.setTipo(new TipoCliente(1l, "Pessoa Física", "PF"));
    }

    public PessoaFisica(PutPessoaFisica dados) {
        super(dados.id(), dados.nome(), new Telefone(dados.telefone()), new Endereco(dados.endereco()), new TipoCliente(dados.tipo()));
        this.nascimento = dados.nascimento();
    }

    public PessoaFisica(String nome, LocalDate nascimento) {
        super(1l, nome);
        this.nascimento = nascimento;
        super.setTipo(new TipoCliente(1l, "Pessoa Física", "PF"));
    }

    public PessoaFisica() {
        super(new TipoCliente(1l, "Pessoa Física", "PF"));
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
