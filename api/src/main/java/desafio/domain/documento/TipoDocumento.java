package desafio.domain.documento;

import jakarta.persistence.*;

@Entity
@Table(
        name="HT_TIPO_DOCUMENTO",
        uniqueConstraints= @UniqueConstraint(columnNames={"nome"}, name = "UK_NOME_TIPO_DOCUMENTO")
)
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_DOCUMENTO")
    @SequenceGenerator(name = "SEQ_HT_TIPO_DOCUMENTO", sequenceName = "SEQ_HT_TIPO_DOCUMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_DOCUMENTO")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;


    public TipoDocumento() {
    }

    public TipoDocumento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public Integer getId() {
        return id;
    }

    public TipoDocumento setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDocumento setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoDocumento{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}