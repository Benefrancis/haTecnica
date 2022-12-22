package desafio.domain.endereco;

import desafio.domain.endereco.dto.PutEstado;
import jakarta.persistence.*;

@Entity
@Table(
        name = "HT_ESTADO"
      // , uniqueConstraints =  @UniqueConstraint(columnNames = {"sigla"}, name = "UK_SIGLA_ESTADO")
)
public class Estado {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_ESTADO")
    @SequenceGenerator(name = "SEQ_HT_ESTADO", sequenceName = "SEQ_HT_ESTADO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ESTADO")
    private Long id;

    private String nome;

    @Column(name = "sigla", nullable = false)
    private String sigla;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", foreignKey = @ForeignKey(name = "FK_PAIS_ESTADO", value = ConstraintMode.CONSTRAINT))
    private Pais pais;


    public Estado(Long id, String nome, String sigla, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
    }

    public Estado() {
    }


    public Estado(PutEstado dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.sigla = dados.sigla();
        this.pais = new Pais(dados.pais());
    }

    public Long getId() {
        return id;
    }

    public Estado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado setPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado setSigla(String sigla) {
        this.sigla = sigla;
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

    }

    @Override
    public String toString() {
        return nome;
    }
}
