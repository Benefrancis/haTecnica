package desafio.domain.documento.service;

import desafio.domain.documento.Documento;
import desafio.domain.documento.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    public List<Documento> findByClienteId(Long id) {
        return repository.findByClienteId(id);
    }

    public Optional<Documento> save(Documento documento) {
        return Optional.of(repository.save(documento));
    }
}
