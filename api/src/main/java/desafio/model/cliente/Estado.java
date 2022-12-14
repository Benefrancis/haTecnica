package desafio.model.cliente;

import desafio.model.cliente.dto.PutEstado;
import jakarta.persistence.*;

@Entity
public class Estado {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO")
    @SequenceGenerator(name = "SEQ_ESTADO", sequenceName = "SEQ_ESTADO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ESTADO")
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", foreignKey = @ForeignKey(name = "FK_PAIS_ESTADO", value = ConstraintMode.CONSTRAINT))
    private Pais pais;


    public Estado(Long id, String nome, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }


    public Estado() {
    }


    public Estado(PutEstado dados) {
        this.id = dados.id();
        this.nome = dados.nome();
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


    public void atualizarInformacoes(PutEstado dados) {

        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
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
