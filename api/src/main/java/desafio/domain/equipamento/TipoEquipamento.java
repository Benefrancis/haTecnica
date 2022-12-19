package desafio.domain.equipamento;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
@Table(
        name = "HT_TIPO_EQUIPAMENTO",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"nome"}, name = "UK_NOME_TIPO_EQUIPAMENTO"),
        indexes = @Index(
                columnList = "nome",
                unique = true,
                name = "IDX_NOME_TIPO_EQUIPAMENTO"
        )
)

public class TipoEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_EQUIPAMENTO")
    @SequenceGenerator(name = "SEQ_HT_TIPO_EQUIPAMENTO", sequenceName = "SEQ_HT_TIPO_EQUIPAMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_EQUIPAMENTO")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public TipoEquipamento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoEquipamento() {
    }

    public Long getId() {
        return id;
    }

    public TipoEquipamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoEquipamento setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoEquipamento{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}