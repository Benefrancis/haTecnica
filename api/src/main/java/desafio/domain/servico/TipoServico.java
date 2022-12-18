package desafio.domain.servico;

import jakarta.persistence.*;

@Entity
@Table(
        name = "HT_TIPO_SERVICO",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"nome"}, name = "UK_NOME_TIPO_SERVICO")
)
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_SERVICO")
    @SequenceGenerator(name = "SEQ_HT_TIPO_SERVICO", sequenceName = "SEQ_HT_TIPO_SERVICO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_SERVICO")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public TipoServico(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoServico() {

    }

    public Long getId() {
        return id;
    }

    public TipoServico setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoServico setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoServico{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}