package desafio.domain.documento.controller;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.documento.Cnpj;
import desafio.domain.documento.Cpf;
import desafio.domain.documento.Documento;
import desafio.domain.documento.Rg;
import desafio.domain.documento.dto.ListDocumento;
import desafio.domain.documento.dto.PutDocumento;
import desafio.domain.documento.service.DocumentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/cliente", "pf", "pj"})
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
    public PutDocumento save(@PathVariable("id") Long id, @RequestBody @Valid PutDocumento doc) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente != null && doc.cliente().id().equals(cliente.getId())) {

            Documento documento = null;

            var t = doc.tipo().getId();

            if (t == 1) {
                documento = new Rg(doc);
            } else if (t == 2) {
                documento = new Cpf(doc);
            } else if (t == 3) {
                documento = new Cnpj(doc);
            } else {
                documento = new Documento(doc);
            }

            documento.setCliente(cliente);

            var docSalvo = service.save(documento).orElse(null);

            return new PutDocumento(docSalvo);

        }

        return null;
    }

}
