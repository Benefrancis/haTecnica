package desafio.domain.documento.controller;

import desafio.domain.documento.TipoDocumento;
import desafio.domain.documento.dto.PutTipoDocumento;
import desafio.domain.documento.repository.TipoDocumentoRepository;
import desafio.domain.equipamento.dto.PutTipoEquipamento;
import desafio.domain.servico.dto.PutTipoServico;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping({"/documento"})
public class DocumentoController {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @GetMapping("/tipo")
    public ResponseEntity<Page<PutTipoDocumento>> findAllTipo(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page =  tipoDocumentoRepository.findAll(paginacao).map(PutTipoDocumento::new);
        return ResponseEntity.ok(page);
    }


    @PostMapping("/tipo")
    public ResponseEntity<PutTipoDocumento> save(@Valid @RequestBody PutTipoDocumento tipo, UriComponentsBuilder builder) {

        if (tipo.nome() != null) {
            if (tipoDocumentoRepository.existsByNomeIgnoreCase(tipo.nome())) {
                throw new EntityExistsException("Já existe Tipo de Documento com o nome: " + tipo.nome());
            } else {
                var save = tipoDocumentoRepository.save(new TipoDocumento(tipo));
                URI uri = builder.path("/documento/tipo/{id}").buildAndExpand(save.getId()).toUri();
                return ResponseEntity.created(uri).body(new PutTipoDocumento(save));
            }
        }
        throw new ValidationException("O nome do Tipo de Documento é obrigatório");
    }



    @GetMapping("/tipo/{id}")
    public ResponseEntity<PutTipoDocumento> save(@PathVariable(name = "id") Long id) {

        var tipo = tipoDocumentoRepository.findById(id).orElse(null);

        if (tipo == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new PutTipoDocumento(tipo));

    }
}
