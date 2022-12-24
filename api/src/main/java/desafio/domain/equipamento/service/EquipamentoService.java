package desafio.domain.equipamento.service;

import desafio.domain.equipamento.Equipamento;
import desafio.domain.equipamento.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public List<Equipamento> findByClienteId(Long id) {
        List<Equipamento> o = repository.findByClienteId(id);
        return o;

    }

    public Optional<Equipamento> save(Equipamento e) {
        return Optional.of(repository.save(e));
    }

    public Optional<Equipamento> findById(Long id) {
        return Optional.of(repository.getReferenceById(id));
    }
}
