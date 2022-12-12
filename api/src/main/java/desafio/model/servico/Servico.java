package desafio.model.servico;

import desafio.model.equipamento.Equipamento;

import java.time.LocalDateTime;

public class Servico {

    private Long id;

    private TipoServico tipo;

    private String descricao;

    private LocalDateTime dataAutorizacao;

    private LocalDateTime dataInicio;

    private LocalDateTime dataConclusao;

    private Equipamento equipamento;

    private double valor;

    public Servico(TipoServico tipo, Equipamento equipamento, double valor) {
        this.tipo = tipo;
        this.equipamento = equipamento;
        this.valor = valor;
    }


    public Servico(Long id, TipoServico tipo, String descricao, LocalDateTime dataAutorizacao, LocalDateTime dataInicio, LocalDateTime dataConclusao, Equipamento equipamento, double valor) {
        this.id = id;
        this.tipo = tipo;
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

    public TipoServico getTipo() {
        return tipo;
    }

    public Servico setTipo(TipoServico tipo) {
        this.tipo = tipo;
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
        String sb = "Servico{" + "id=" + id +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                ", dataAutorizacao=" + dataAutorizacao +
                ", dataInicio=" + dataInicio +
                ", dataConclusao=" + dataConclusao +
                ", equipamento=" + equipamento +
                ", valor=" + valor +
                '}';
        return sb;
    }


    public enum TipoServico {
        ORCAMENTO(1, "Orçamento"), LIMPEZA(2, "Limpeza"), SUBSTITUICAO_DE_PECA(3, "Substituição de Peça");

        private final int valor;
        private final String nome;

        TipoServico(int i, String nome) {
            valor = i;
            this.nome = nome;
        }

        public int getValor() {
            return valor;
        }

        public String getNome() {
            return nome;
        }


        @Override
        public String toString() {
            String sb = "TipoServico{" + "valor=" + valor +
                    ", nome='" + nome + '\'' +
                    '}';
            return sb;
        }
    }
}
