package desafio.domain.endereco;

import desafio.domain.endereco.dto.PutCidade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HT_CIDADE",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"ID_CIDADE"},
                name = "PK_CIDADE"),
        indexes = {
                @Index(
                        columnList = "NOME ",
                        name = "IDX_NOME_CIDADE"
                )
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cidade {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_CIDADE")
    @SequenceGenerator(name = "SEQ_HT_CIDADE", sequenceName = "SEQ_HT_CIDADE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CIDADE")
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO", foreignKey = @ForeignKey(name = "FK_ESTADO_CIDADE", value = ConstraintMode.CONSTRAINT))
    private Estado estado;


    public Cidade(PutCidade dados) {
        this.id = dados.id();
        this.estado = new Estado(dados.estado());
        this.nome = dados.nome();
    }


    public Cidade setId(Long id) {
        this.id = id;
        return this;
    }


    public Cidade setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public Cidade setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }


    public void atualizarInformacoes(PutCidade dados) {

        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
        }

        if (!dados.estado().equals(null)) {
            this.estado.atualizarInformacoes(dados.estado());
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cidade{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
}

