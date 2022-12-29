package desafio.domain.documento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.documento.dto.PutTipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "HT_TIPO_DOCUMENTO",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "ID_TIPO_DOCUMENTO",
                        name = "PK_TIPO_DOCUMENTO"
                ),
                @UniqueConstraint(
                        columnNames = "NOME",
                        name = "UK_NOME_TIPO_DOCUMENTO"
                )
        },
        indexes = @Index(
                columnList = "nome",
                name = "IDX_NOME_TIPO_DOCUMENTO"
        )
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_TIPO_DOCUMENTO")
    @SequenceGenerator(name = "SEQ_HT_TIPO_DOCUMENTO", sequenceName = "SEQ_HT_TIPO_DOCUMENTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_TIPO_DOCUMENTO")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public TipoDocumento(PutTipoDocumento td) {
        this.id = td.id();
        this.nome = td.nome();
    }

    public TipoDocumento setId(Long id) {
        this.id = id;
        return this;
    }

    public TipoDocumento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public static TipoDocumento RG() {
        return TipoDocumento.builder()
                .id(1L)
                .nome("RG")
                .build();
    }

    public static TipoDocumento CPF() {
        return TipoDocumento.builder()
                .id(2L)
                .nome("CPF")
                .build();
    }

    public static TipoDocumento CNPJ() {
        return TipoDocumento.builder()
                .id(3L)
                .nome("CNPJ")
                .build();
    }

    @Override
    public String toString() {
        String sb = "TipoDocumento{" + "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
        return sb;
    }
}