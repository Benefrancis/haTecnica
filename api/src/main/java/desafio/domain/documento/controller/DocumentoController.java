package desafio.domain.documento.controller;

import desafio.domain.documento.dto.ListDocumento;
import desafio.domain.documento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class DocumentoController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}/documento")
    public List<ListDocumento> findByClienteId(@PathVariable("id") Long id) {
        return service.findByClienteId(id).stream().map(ListDocumento::new).toList();
    }

}
