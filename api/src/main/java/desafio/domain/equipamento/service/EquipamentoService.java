package desafio.domain.equipamento.service;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.equipamento.Equipamento;
import desafio.domain.equipamento.TipoEquipamento;
import desafio.domain.equipamento.dto.PutEquipamento;
import desafio.domain.equipamento.repository.EquipamentoRepository;
import desafio.domain.equipamento.repository.TipoEquipamentoRepository;
import desafio.infra.exception.EntidadeNaoEncontradaException;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public Page<Equipamento> findByClienteId(@Min(value = 1, message = "Informe o ID da entidade") Long id, Pageable paginacao) {
        return repository.findByClienteId(id, paginacao);
    }

    public Equipamento save(PutEquipamento e) throws EntidadeNaoEncontradaException, ValidationException {

        Cliente cliente = clienteRepository.findById(e.cliente().id()).orElse(null);

        if (cliente == null) {
            var msg = String.format("Não existe Cliente cadastrado com o ID: %s", e.cliente().id());
            throw new EntidadeNaoEncontradaException(msg);
        }

        if (!e.cliente().id().equals(cliente.getId())) {
            throw new ValidationException("O ID do cliente no Json do Equipamento deve ser o mesmo da URI");
        }

        TipoEquipamento tipoEquipamento = tipoEquipamentoRepository.findById(e.tipo().id()).orElse(null);


        if(tipoEquipamento==null){
            var msg = String.format("Não existe Tipo de Equipamento cadastrado com o ID: %s", e.tipo().id());
            throw new EntidadeNaoEncontradaException(msg);
        }

        var equipamento = new Equipamento(e);
        equipamento.setCliente(cliente);
        equipamento.setTipo(tipoEquipamento);
        return repository.save(equipamento);
    }

    public Optional<Equipamento> findById(Long id) {
        return Optional.of(repository.getReferenceById(id));
    }

}
