package desafio.domain.equipamento.service;

import desafio.domain.documento.Documento;
import desafio.domain.equipamento.Equipamento;
import desafio.domain.equipamento.repository.EquipamentoRepository;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public Page<Equipamento> findByClienteId(@Min(value = 1, message = "Informe o ID da entidade")  Long id, Pageable paginacao) {
        return repository.findByClienteId(id, paginacao);


    }

    public Optional<Equipamento> save(Equipamento e) {
        return Optional.of(repository.save(e));
    }

    public Optional<Equipamento> findById(Long id) {
        return Optional.of(repository.getReferenceById(id));
    }
}
