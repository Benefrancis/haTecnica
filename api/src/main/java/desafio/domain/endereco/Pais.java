package desafio.domain.endereco;

import desafio.domain.endereco.dto.PutPais;
import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name="HT_PAIS", uniqueConstraints= @UniqueConstraint(columnNames={"nome"}, name = "UK_NOME_PAIS"))
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_PAIS")
    @SequenceGenerator(name = "SEQ_HT_PAIS", sequenceName = "SEQ_HT_PAIS", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_PAIS")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais(PutPais dados) {
        this.id = dados.id();
        this.nome = dados.nome();
    }

    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public Pais setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pais setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public void atualizarInformacoes(PutPais dados) {

        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
        }
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Pais.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .toString();
    }
}
