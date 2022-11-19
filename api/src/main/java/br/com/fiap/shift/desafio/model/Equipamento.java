package br.com.fiap.shift.desafio.model;

public class Equipamento {

    private Long id;

    private Cliente cliente;

    private String numeroDeSerie;

    private TipoEquipamento tipo;


    public Equipamento(Cliente cliente, TipoEquipamento tipo) {
        this.cliente = cliente;
        this.tipo = tipo;
    }


    public Equipamento(Long id, Cliente cliente, String numeroDeSerie, TipoEquipamento tipo) {
        this.id = id;
        this.cliente = cliente;
        this.numeroDeSerie = numeroDeSerie;
        this.tipo = tipo;
    }

    enum TipoEquipamento {
        COMPUTADOR, MOBILE, VIDEO_GAME
    }



}
