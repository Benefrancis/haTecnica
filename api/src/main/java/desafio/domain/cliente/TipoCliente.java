package desafio.domain.cliente;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.dto.PutTipoCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "HT_TIPO_CLIENTE",
    uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = {"ID_TIPO_CLIENTE"},
                    name = "PK_TIPO_CLIENTE"
            ),
            @UniqueConstraint(
                    columnNames = {"NOME"},
                    name = "UK_NOME_TIPO_CLIENTE"
            )
    },
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
                .id(1L)
                .nome("Pessoa Física")
                .sigla("PF")
                .build();
    }

    public static TipoCliente PJ() {
        return TipoCliente.builder()
                .id(2L)
                .nome("Pessoa Jurídica")
                .sigla("PJ")
                .build();
    }

    @Override
    public String toString() {
        String sb = "TipoCliente{" + "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
        return sb;
    }
}