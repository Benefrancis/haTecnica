package desafio.domain.equipamento;

import desafio.domain.equipamento.dto.PutTipoEquipamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "HT_TIPO_EQUIPAMENTO",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"nome"},
                name = "UK_NOME_TIPO_EQUIPAMENTO")
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_EQUIPAMENTO")
    @SequenceGenerator(name = "SEQ_HT_TIPO_EQUIPAMENTO", sequenceName = "SEQ_HT_TIPO_EQUIPAMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_EQUIPAMENTO")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;


    public TipoEquipamento(PutTipoEquipamento te) {
        this.id = te.id();
        this.nome = te.nome();
    }

    public TipoEquipamento setId(Long id) {
        this.id = id;
        return this;
    }

    public TipoEquipamento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public void atualizarInforamcoes(PutTipoEquipamento te) {
        if (te.nome() != null) {
            this.nome = te.nome();
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoEquipamento{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static TipoEquipamento COMPUTADOR() {
        return TipoEquipamento.builder()
                .id(1l)
                .nome("Computador")
                .build();
    }

    public static TipoEquipamento NOTEBOOK() {
        return TipoEquipamento.builder()
                .id(2l)
                .nome("Notebook")
                .build();
    }

    public static TipoEquipamento CELULAR() {
        return TipoEquipamento.builder()
                .id(3l)
                .nome("Celular")
                .build();
    }

    public static TipoEquipamento TABLET() {
        return TipoEquipamento.builder()
                .id(4l)
                .nome("Tablet")
                .build();
    }

    public static TipoEquipamento VIDEO_GAME() {
        return TipoEquipamento.builder()
                .id(5l)
                .nome("Vídeo Game")
                .build();
    }

}