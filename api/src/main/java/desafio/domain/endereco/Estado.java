package desafio.domain.endereco;

import desafio.domain.endereco.dto.PutEstado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "HT_ESTADO"
        // , uniqueConstraints =  @UniqueConstraint(columnNames = {"sigla"}, name = "UK_SIGLA_ESTADO")
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estado {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_ESTADO")
    @SequenceGenerator(name = "SEQ_HT_ESTADO", sequenceName = "SEQ_HT_ESTADO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ESTADO")
    private Long id;

    private String nome;

    @Column(name = "sigla", nullable = false)
    private String sigla;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", foreignKey = @ForeignKey(name = "FK_PAIS_ESTADO", value = ConstraintMode.CONSTRAINT))
    private Pais pais;

    @Column(name = "IBGE", nullable = false)
    private Long ibge;

    public Estado(PutEstado dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.sigla = dados.sigla();
        this.pais = new Pais(dados.pais());
        this.ibge = dados.ibge();
    }


    public Estado setId(Long id) {
        this.id = id;
        return this;
    }


    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public Estado setPais(Pais pais) {
        this.pais = pais;
        return this;
    }


    public Estado setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }


    public Estado setIbge(Long ibge) {
        this.ibge = ibge;
        return this;
    }

    public void atualizarInformacoes(PutEstado dados) {

        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
        }

        if (!dados.sigla().equals(null)) {
            this.sigla = dados.sigla();
        }

        if (!dados.pais().equals(null)) {
            this.pais.atualizarInformacoes(dados.pais());
        }

        if (!dados.ibge().equals(null)) {
            this.ibge = dados.ibge();
        }

    }


    public static Estado SP() {
        return Estado.builder().id(1L).ibge(35L).nome("São Paulo").sigla("SP").pais(Pais.BRASIL()).build();
    }

    public static Estado PR() {
        return Estado.builder().id(2L).ibge(41L).nome("Paraná").sigla("PR").pais(Pais.BRASIL()).build();
    }

    public static Estado SC() {
        return Estado.builder().id(3L).ibge(42L).nome("Santa Catarina").sigla("SC").pais(Pais.BRASIL()).build();
    }

    public static Estado RS() {
        return Estado.builder().id(4L).ibge(43L).nome("Rio Grande do Sul").sigla("RS").pais(Pais.BRASIL()).build();
    }

    public static Estado MS() {
        return Estado.builder().id(5L).ibge(50L).nome("Mato Grosso do Sul").sigla("MS").pais(Pais.BRASIL()).build();
    }

    public static Estado RO() {
        return Estado.builder().id(6L).ibge(11L).nome("Rondônia").sigla("RO").pais(Pais.BRASIL()).build();
    }

    public static Estado AC() {
        return Estado.builder().id(7L).ibge(12L).nome("Acre").sigla("AC").pais(Pais.BRASIL()).build();
    }

    public static Estado AM() {
        return Estado.builder().id(8L).ibge(13L).nome("Amazonas").sigla("AM").pais(Pais.BRASIL()).build();
    }

    public static Estado RR() {
        return Estado.builder().id(9L).ibge(14L).nome("Roraima").sigla("RR").pais(Pais.BRASIL()).build();
    }

    public static Estado PA() {
        return Estado.builder().id(10L).ibge(15L).nome("Pará").sigla("PA").pais(Pais.BRASIL()).build();
    }

    public static Estado AP() {
        return Estado.builder().id(11L).ibge(16L).nome("Amapá").sigla("AP").pais(Pais.BRASIL()).build();
    }

    public static Estado TO() {
        return Estado.builder().id(12L).ibge(17L).nome("Tocantins").sigla("TO").pais(Pais.BRASIL()).build();
    }

    public static Estado MA() {
        return Estado.builder().id(13L).ibge(21L).nome("Maranhão").sigla("MA").pais(Pais.BRASIL()).build();
    }

    public static Estado RN() {
        return Estado.builder().id(14L).ibge(24L).nome("Rio Grande do Norte").sigla("RN").pais(Pais.BRASIL()).build();
    }

    public static Estado PB() {
        return Estado.builder().id(15L).ibge(25L).nome("Paraíba").sigla("PB").pais(Pais.BRASIL()).build();
    }

    public static Estado PE() {
        return Estado.builder().id(16L).ibge(26L).nome("Pernambuco").sigla("PE").pais(Pais.BRASIL()).build();
    }

    public static Estado AL() {
        return Estado.builder().id(17L).ibge(27L).nome("Alagoas").sigla("AL").pais(Pais.BRASIL()).build();
    }

    public static Estado SE() {
        return Estado.builder().id(18L).ibge(28L).nome("Sergipe").sigla("SE").pais(Pais.BRASIL()).build();
    }

    public static Estado BA() {
        return Estado.builder().id(19L).ibge(29L).nome("Bahia").sigla("BA").pais(Pais.BRASIL()).build();
    }

    public static Estado MG() {
        return Estado.builder().id(20L).ibge(31L).nome("Minas Gerais").sigla("MG").pais(Pais.BRASIL()).build();
    }

    public static Estado RJ() {
        return Estado.builder().id(21L).ibge(33L).nome("Rio de Janeiro").sigla("RJ").pais(Pais.BRASIL()).build();
    }

    public static Estado MT() {
        return Estado.builder().id(22L).ibge(51L).nome("Mato Grosso").sigla("MT").pais(Pais.BRASIL()).build();
    }

    public static Estado GO() {
        return Estado.builder().id(23L).ibge(52L).nome("Goiás").sigla("GO").pais(Pais.BRASIL()).build();
    }

    public static Estado DF() {
        return Estado.builder().id(24L).ibge(53L).nome("Distrito Federal").sigla("DF").pais(Pais.BRASIL()).build();
    }

    public static Estado PI() {
        return Estado.builder().id(25L).ibge(22L).nome("Piauí").sigla("PI").pais(Pais.BRASIL()).build();
    }

    public static Estado CE() {
        return Estado.builder().id(26L).ibge(23L).nome("Ceará").sigla("CE").pais(Pais.BRASIL()).build();
    }

    public static Estado ES() {
        return Estado.builder().id(27L).ibge(32L).nome("Espírito Santo").sigla("ES").pais(Pais.BRASIL()).build();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estado{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", sigla='").append(sigla).append('\'');
        sb.append(", pais=").append(pais);
        sb.append(", ibge=").append(ibge);
        sb.append('}');
        return sb.toString();
    }
}
