package desafio.domain.endereco;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.endereco.dto.PutPais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.StringJoiner;

@Entity
@Table(name = "HT_PAIS",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"ID_PAIS"},
                        name = "FK_PAIS"
                ),
                @UniqueConstraint(
                        columnNames = "NOME",
                        name = "UK_NOME_PAIS"
                )

        },
        indexes = @Index(
                columnList = "nome",
                name = "IDX_NOME_PAIS"
        )
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_PAIS")
    @SequenceGenerator(name = "SEQ_HT_PAIS", sequenceName = "SEQ_HT_PAIS", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_PAIS")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Pais(PutPais dados) {
        this.id = dados.id();
        this.nome = dados.nome();
    }

    public Pais setId(Long id) {
        this.id = id;
        return this;
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

    public static Pais BRASIL() {
        return Pais.builder()
                .id(1L)
                .nome("Brasil")
                .build();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pais.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .toString();
    }
}
