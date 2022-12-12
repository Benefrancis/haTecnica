package desafio.model.cliente;

import java.time.LocalDate;
import java.util.StringJoiner;

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
        return new StringJoiner(", ", PessoaFisica.class.getSimpleName() + "[", "]")
                .add("nascimento=" + nascimento)
                .add(super.toString())
                .toString();
    }
}
