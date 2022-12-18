package desafio.domain.documento.service;

import desafio.domain.documento.Documento;
import desafio.domain.documento.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private DocumentoRepository repository;

    public List<Documento> findByClienteId(Long id) {
        return repository.findByClienteId(id);
    }

}
