package desafio.domain.servico;

import desafio.domain.equipamento.Equipamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="HT_SERVICO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_SERVICO")
    @SequenceGenerator(name = "SEQ_HT_SERVICO", sequenceName = "SEQ_HT_SERVICO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_SERVICO")
    private Long id;

    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_AUTORIZACAO")
    private LocalDateTime dataAutorizacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_INICIO")
    private LocalDateTime dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CONCLUSAO")
    private LocalDateTime dataConclusao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_EQUIPAMENTO", referencedColumnName = "ID_EQUIPAMENTO", foreignKey = @ForeignKey(name = "FK_EQUIPAMENTO_SERVICO", value = ConstraintMode.CONSTRAINT))
    private Equipamento equipamento;

    private double valor;

    public Servico() {

    }

    public Servico(Long id, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor) {
        this.id = id;

        this.descricao = descricao;
        this.dataAutorizacao = dataAutorizacao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.equipamento = equipamento;
        this.valor = valor;
    }


    public Long getId() {
        return id;
    }

    public Servico setId(Long id) {
        this.id = id;
        return this;
    }


    public String getDescricao() {
        return descricao;
    }

    public Servico setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public LocalDateTime getDataAutorizacao() {
        return dataAutorizacao;
    }

    public Servico setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
        return this;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public Servico setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public Servico setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
        return this;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Servico setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
        return this;
    }

    public double getValor() {
        return valor;
    }

    public Servico setValor(double valor) {
        this.valor = valor;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Servico{");
        sb.append("id=").append(id);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", dataAutorizacao=").append(dataAutorizacao);
        sb.append(", dataInicio=").append(dataInicio);
        sb.append(", dataConclusao=").append(dataConclusao);
        sb.append(", equipamento=").append(equipamento);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
}
