package desafio.domain.servico;

import desafio.domain.servico.dto.PutTipoServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "HT_TIPO_SERVICO",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "ID_TIPO_SERVICO",
                        name = "PK_TIPO_SERVICO"
                ),
                @UniqueConstraint(
                        columnNames = "NOME",
                        name = "UK_NOME_TIPO_SERVICO"
                )
        },
        indexes = {@Index(
                columnList = "NOME ",
                name = "IDX_NOME_TIPO_SERVICO"
        )
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_SERVICO")
    @SequenceGenerator(name = "SEQ_HT_TIPO_SERVICO", sequenceName = "SEQ_HT_TIPO_SERVICO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_SERVICO")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public TipoServico(PutTipoServico ts) {
        this.id = ts.id();
        this.nome = ts.nome();
    }

    public TipoServico setId(Long id) {
        this.id = id;
        return this;
    }

    public TipoServico setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public void atualizarInforamcoes(PutTipoServico ts) {
        if (ts.nome() != null) {
            this.nome = ts.nome();
        }
    }


    public static TipoServico ORCAMENTO() {
        return TipoServico.builder()
                .id(1l)
                .nome("Orçamento")
                .build();
    }

    public static TipoServico VISITA_TECNICA() {
        return TipoServico.builder()
                .id(2l)
                .nome("Visita Técnica")
                .build();
    }

    public static TipoServico LIMPEZA() {
        return TipoServico.builder()
                .id(3l)
                .nome("Limpeza")
                .build();
    }

    public static TipoServico SUBSTITUICAO_DE_PECA() {
        return TipoServico.builder()
                .id(4l)
                .nome("Substituição de Peça")
                .build();
    }

    public static TipoServico UPGRADE_DE_SISTEMA_OPERACIONAL() {
        return TipoServico.builder()
                .id(5l)
                .nome("Upgrade de Sistema Operacional")
                .build();
    }

    public static TipoServico INSTALACAO_DE_SOFTWARE() {
        return TipoServico.builder()
                .id(6l)
                .nome("Instalação de Software")
                .build();
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