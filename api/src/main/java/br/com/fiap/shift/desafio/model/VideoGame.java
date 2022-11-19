package br.com.fiap.shift.desafio.model;

public class VideoGame extends Equipamento {
    public VideoGame(Cliente cliente) {
        super(cliente, TipoEquipamento.VIDEO_GAME);
    }

    public VideoGame(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.VIDEO_GAME);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VideoGame{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
