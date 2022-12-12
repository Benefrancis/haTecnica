package desafio.model.cliente;

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
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO", foreignKey = @ForeignKey(name = "FK_ESTADO_CIDADE", value = ConstraintMode.CONSTRAINT) )
    private Estado estado;

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
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

}

@Entity
class Estado {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO")
    @SequenceGenerator(name = "SEQ_ESTADO", sequenceName = "SEQ_ESTADO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ESTADO")
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS",foreignKey = @ForeignKey(name = "FK_PAIS_ESTADO", value = ConstraintMode.CONSTRAINT) )
    private Pais pais;

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

    @Override
    public String toString() {
        return nome;
    }

}
@Entity
class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAIS")
    @SequenceGenerator(name = "SEQ_PAIS", sequenceName = "SEQ_PAIS", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_PAIS")
    private Long id;

    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome;
    }

}
