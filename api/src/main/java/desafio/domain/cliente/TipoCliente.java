package desafio.domain.cliente;


import desafio.domain.cliente.dto.PutTipoCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "HT_TIPO_CLIENTE",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"nome"},
                name = "UK_NOME_TIPO_CLIENTE"),
        indexes = @Index(
                columnList = "nome",
                name = "IDX_NOME_TIPO_CLIENTE"
        )

)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_CLIENTE")
    @SequenceGenerator(name = "SEQ_HT_TIPO_CLIENTE", sequenceName = "SEQ_HT_TIPO_CLIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_CLIENTE")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sigla")
    private String sigla;

    public TipoCliente(PutTipoCliente dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.sigla = dados.sigla();
    }


    public TipoCliente setId(Long id) {
        this.id = id;
        return this;
    }


    public TipoCliente setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public TipoCliente setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    public void atualizarInformacoes(PutTipoCliente dados) {

        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
        }

        if (!dados.sigla().equals(null)) {
            this.sigla = dados.sigla();
        }

    }


    public static TipoCliente PF() {
        return TipoCliente.builder()
                .id(1l)
                .nome("Pessoa Física")
                .sigla("PF")
                .build();
    }

    public static TipoCliente PJ() {
        return TipoCliente.builder()
                .id(2l)
                .nome("Pessoa Jurídica")
                .sigla("PJ")
                .build();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoCliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", sigla='").append(sigla).append('\'');
        sb.append('}');
        return sb.toString();
    }
}