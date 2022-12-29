package desafio.domain.servico.service;

import desafio.domain.equipamento.repository.EquipamentoRepository;
import desafio.domain.servico.Servico;
import desafio.domain.servico.dto.PutServico;
import desafio.domain.servico.repository.ServicoRepository;
import desafio.domain.servico.repository.TipoServicoRepository;
import desafio.infra.exception.EntidadeNaoEncontradaException;
import desafio.infra.exception.TipoServicoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {


    @Autowired
    private ServicoRepository repository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;


    @Autowired
    private TipoServicoRepository tipoServicoRepository;


    public Servico save(PutServico dados) throws TipoServicoNotFoundException, EntidadeNaoEncontradaException {

        //Verificando se existe equipamento com o id informado
        var equipamento = equipamentoRepository.findById(dados.equipamento().id()).orElse(null);
        if (equipamento == null) {
            var msg = String.format("Não existe Equipamento cadastrado com o ID: %s", dados.equipamento().id());
            throw new EntidadeNaoEncontradaException(msg);
        }


        //verificando se existe tipo de serviço informado
        var tipoServico = tipoServicoRepository.findById(dados.tipo().id()).orElse(null);
        if (tipoServico == null) {
            var msg = String.format("Não existe Tipo de Servico cadastrado com o ID: %s", dados.tipo().id());
            throw new TipoServicoNotFoundException(msg);
        }


        var servico = new Servico(dados);
        servico.setEquipamento(equipamento);
        servico.setTipo(tipoServico);
        servico = repository.save(servico);

        return servico;
    }
}
