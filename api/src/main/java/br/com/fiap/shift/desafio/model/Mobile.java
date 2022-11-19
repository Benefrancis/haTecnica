package br.com.fiap.shift.desafio.model;

public class Mobile extends Equipamento {
    public Mobile(Cliente cliente) {
        super(cliente, TipoEquipamento.MOBILE);
    }

    public Mobile(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.MOBILE);
    }
}
