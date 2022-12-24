package desafio.domain.documento.service;

import desafio.domain.documento.Documento;
import desafio.domain.documento.repository.DocumentoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    public Page<Documento> findByClienteId(@Min(value = 1, message = "Informe o ID da entidade")  Long id, Pageable paginacao) {
        return repository.findByClienteId(id, paginacao);
    }

    public Optional<Documento> save(@Valid Documento documento) {
        return Optional.of(repository.save(documento));
    }

    public Optional<Documento> findById(@Min(value = 1, message = "Informe o ID da entidade") Long id) {
        return repository.findById(id);
    }


}
