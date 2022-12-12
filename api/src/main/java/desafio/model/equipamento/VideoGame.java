package desafio.model.equipamento;

import desafio.model.cliente.Cliente;

public class VideoGame extends Equipamento {
    public VideoGame(Cliente cliente) {
        super(cliente, TipoEquipamento.VIDEO_GAME);
    }

    public VideoGame(Long id, Cliente cliente, String numeroDeSerie) {
        super(id, cliente, numeroDeSerie, TipoEquipamento.VIDEO_GAME);
    }


    @Override
    public String toString() {
        String sb = "VideoGame{" + super.toString() +
                '}';
        return sb;
    }
}
