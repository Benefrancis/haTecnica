package desafio.domain.equipamento.controller;

import desafio.domain.documento.repository.TipoDocumentoRepository;
import desafio.domain.equipamento.TipoEquipamento;
import desafio.domain.equipamento.dto.PutTipoEquipamento;
import desafio.domain.equipamento.repository.TipoEquipamentoRepository;
import desafio.domain.servico.dto.PutTipoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping({"/equipamento"})
public class EquipamentoController {

    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;


    @GetMapping("/tipo")
    public Page<PutTipoEquipamento> findAllTipo(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return tipoEquipamentoRepository.findAll(paginacao).map(PutTipoEquipamento::new);
    }

    @PostMapping("/tipo")
    public ResponseEntity<PutTipoEquipamento> save(@Valid @RequestBody PutTipoEquipamento tipo, UriComponentsBuilder builder) {

        if (tipo.nome() != null) {
            if (tipoEquipamentoRepository.existsByNomeIgnoreCase(tipo.nome())) {
                throw new RuntimeException("Já existe Tipo de Equipamento com o nome: " + tipo.nome());
            } else {
                var save = tipoEquipamentoRepository.save(new TipoEquipamento(tipo));
                URI uri = builder.path("/equipamento/tipo/{id}").buildAndExpand(save.getId()).toUri();
                return ResponseEntity.created(uri).body(new PutTipoEquipamento(save));
            }
        }
        throw new RuntimeException("O nome do Tipo de Equipamento é obrigatório");
    }


    @GetMapping("/tipo/{id}")
    public ResponseEntity<PutTipoEquipamento> save(@PathVariable(name = "id") Long id) {

        var tipo = tipoEquipamentoRepository.findById(id).orElse(null);

        if (tipo == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new PutTipoEquipamento(tipo));

    }

}
