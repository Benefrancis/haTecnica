package desafio.domain.servico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.equipamento.Equipamento;
import desafio.domain.servico.dto.PutServico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "HT_SERVICO",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"ID_SERVICO"},
                name = "PK_SERVICO"),
        indexes = {
                @Index(
                        columnList = "DT_AUTORIZACAO",
                        name = "IDX_DT_AUTORIZACAO"
                ),

                @Index(
                        columnList = "DT_INICIO, DT_CONCLUSAO ",
                        name = "IDX_DT_INICIO"
                ),
                @Index(
                        columnList = "DT_CONCLUSAO ",
                        name = "IDX_DT_CONCLUSAO"
                )
        }
)
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_SERVICO")
    @SequenceGenerator(name = "SEQ_HT_SERVICO", sequenceName = "SEQ_HT_SERVICO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_SERVICO")
    private Long id;

    private String descricao;

    private double valor;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_AUTORIZACAO")
    private LocalDateTime dataAutorizacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_INICIO")
    private LocalDateTime dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CONCLUSAO")
    private LocalDateTime dataConclusao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH})
    @JoinColumn(name = "ID_TIPO_SERVICO", referencedColumnName = "ID_TIPO_SERVICO", foreignKey = @ForeignKey(name = "FK_TIPO_SERVICO", value = ConstraintMode.CONSTRAINT))
    private TipoServico tipo;


    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH})
    @JoinColumn(name = "ID_EQUIPAMENTO", referencedColumnName = "ID_EQUIPAMENTO", foreignKey = @ForeignKey(name = "FK_EQUIPAMENTO_SERVICO", value = ConstraintMode.CONSTRAINT))
    private Equipamento equipamento;

    public Servico(PutServico s) {
        this.id = s.id();
        this.descricao = s.descricao();
        this.valor = s.valor();
        if (s.tipo() != null) this.tipo = new TipoServico(s.tipo());
        this.dataAutorizacao = s.dataAutorizacao();
        this.dataInicio = s.dataInicio();
        this.dataConclusao = s.dataConclusao();
        if (s.equipamento() != null) this.equipamento = new Equipamento(s.equipamento());
    }


    public Servico setId(Long id) {
        this.id = id;
        return this;
    }


    public Servico setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }


    public Servico setValor(double valor) {
        this.valor = valor;
        return this;
    }


    public Servico setTipo(TipoServico tipo) {
        this.tipo = tipo;
        return this;
    }


    public Servico setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
        return this;
    }


    public Servico setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }


    public Servico setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
        return this;
    }


    public Servico setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
        return this;
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
