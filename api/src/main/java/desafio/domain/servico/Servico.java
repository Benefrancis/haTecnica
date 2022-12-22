package desafio.domain.servico;

import desafio.domain.equipamento.Equipamento;
import desafio.domain.servico.dto.PutServico;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "HT_SERVICO")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_SERVICO")
    @SequenceGenerator(name = "SEQ_HT_SERVICO", sequenceName = "SEQ_HT_SERVICO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_SERVICO")
    private Long id;

    private String descricao;

    private double valor;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_SERVICO", referencedColumnName = "ID_TIPO_SERVICO", foreignKey = @ForeignKey(name = "FK_TIPO_SERVICO", value = ConstraintMode.CONSTRAINT), insertable = false, updatable = false)
    private TipoServico tipo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_AUTORIZACAO")
    private LocalDateTime dataAutorizacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_INICIO")
    private LocalDateTime dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CONCLUSAO")
    private LocalDateTime dataConclusao;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_EQUIPAMENTO", referencedColumnName = "ID_EQUIPAMENTO", foreignKey = @ForeignKey(name = "FK_EQUIPAMENTO_SERVICO", value = ConstraintMode.CONSTRAINT))
    private Equipamento equipamento;

    public Servico() {

    }

    public Servico(Long id, String descricao, double valor, TipoServico tipo, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.dataAutorizacao = dataAutorizacao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.equipamento = equipamento;
    }

    public Servico(PutServico s) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.dataAutorizacao = dataAutorizacao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.equipamento = equipamento;
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

    public double getValor() {
        return valor;
    }

    public Servico setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public Servico setTipo(TipoServico tipo) {
        this.tipo = tipo;
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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Servico{");
        sb.append("id=").append(id);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", valor=").append(valor);
        sb.append(", tipo=").append(tipo);
        sb.append(", dataAutorizacao=").append(dataAutorizacao);
        sb.append(", dataInicio=").append(dataInicio);
        sb.append(", dataConclusao=").append(dataConclusao);
        sb.append(", equipamento=").append(equipamento);
        sb.append('}');
        return sb.toString();
    }

    public void atualizarInformacoes(PutServico d) {

        if (d.dataConclusao() != null) {
            this.dataConclusao = d.dataConclusao();
        }

        if (d.tipo() != null) {
            if (this.getTipo() != null) {
                this.getTipo().atualizarInforamcoes(d.tipo());
            } else {
                this.setTipo(new TipoServico(d.tipo()));
            }
        }

        if (d.descricao() != null) {
            this.descricao = d.descricao();
        }

        if (d.dataAutorizacao() != null) {
            this.dataAutorizacao = d.dataAutorizacao();
        }

        if (d.dataInicio() != null) {
            this.dataInicio = d.dataInicio();
        }
        if (d.equipamento() != null) {
            if (this.getEquipamento() != null) {
                this.getEquipamento().atualizarInforamcoes(d.equipamento());
            } else {
                this.setEquipamento(new Equipamento(d.equipamento()));
            }
        }

        if (d.valor() != 0) {
            this.valor = d.valor();
        }
    }

}
