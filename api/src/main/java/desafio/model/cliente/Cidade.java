package desafio.model.cliente;

import desafio.model.cliente.dto.PutCidade;
import jakarta.persistence.*;

@Entity
public class Cidade {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CIDADE")
    @SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_CIDADE")
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO", foreignKey = @ForeignKey(name = "FK_ESTADO_CIDADE", value = ConstraintMode.CONSTRAINT))
    private Estado estado;

    public Cidade() {
    }

    public Cidade(PutCidade dados) {

        this.id = dados.id();
        this.estado = new Estado(dados.estado());
        this.nome = dados.nome();

    }


    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Cidade setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cidade setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cidade setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public String toString() {
        return nome;
    }

    public void atualizarInformacoes(PutCidade dados) {


        if (!dados.nome().equals(null)) {
            this.nome = dados.nome();
        }

        if (!dados.estado().equals(null)) {
            this.estado.atualizarInformacoes(dados.estado());
        }
    }
}

