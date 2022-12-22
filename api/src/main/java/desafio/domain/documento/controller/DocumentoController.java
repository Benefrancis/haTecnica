package desafio.domain.documento.controller;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.documento.Documento;
import desafio.domain.documento.dto.ListDocumento;
import desafio.domain.documento.dto.PutDocumento;
import desafio.domain.documento.service.DocumentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/cliente"})
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/{id}/documento")
    public List<ListDocumento> findByClienteId(@PathVariable("id") Long id) {
        return service.findByClienteId(id).stream().map(ListDocumento::new).toList();
    }

    @PostMapping("/{id}/documento")
    @Transactional
    public ResponseEntity<PutDocumento> save(@PathVariable("id") Long id, @RequestBody @Valid PutDocumento doc, UriComponentsBuilder builder) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente != null && doc.cliente().id().equals(cliente.getId())) {
            var documento = new Documento(doc);
            documento.setCliente(cliente);
            documento = service.save(documento).orElse(null);
            var ret = new PutDocumento(documento);
            URI uri = builder.path("/cliente/{id}").buildAndExpand(ret.id()).toUri();
            return ResponseEntity.created(uri).body(ret);
        } else {
            var err = new RuntimeException("O ID do cliente no Json do documento deve ser o mesmo da URI");
            err.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
