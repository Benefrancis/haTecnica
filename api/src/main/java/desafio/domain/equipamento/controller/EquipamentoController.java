package desafio.domain.equipamento.controller;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.documento.dto.ListDocumento;
import desafio.domain.equipamento.Equipamento;
import desafio.domain.equipamento.dto.ListEquipamento;
import desafio.domain.equipamento.dto.PutEquipamento;
import desafio.domain.equipamento.service.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/cliente"})
public class EquipamentoController {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoService service;


    @GetMapping("/{id}/equipamento")
    public ResponseEntity<Page<ListEquipamento>> findByClienteId(@PathVariable("id") Long id, @PageableDefault(size = 10, sort = {"cliente.nome"}) Pageable paginacao) {
        var cliente = IsValidCliente(id);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.findByClienteId(id, paginacao).map(ListEquipamento::new));
    }

    @PostMapping("/{id}/equipamento")
    @Transactional
    public ResponseEntity<PutEquipamento> save(@PathVariable("id") Long id, @RequestBody @Valid PutEquipamento eq, UriComponentsBuilder builder) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null && eq.cliente().id().equals(cliente.getId())) {
            var equipamento = new Equipamento(eq);
            equipamento.setCliente(cliente);
            equipamento = service.save(equipamento).orElse(null);
            var ret = new PutEquipamento(equipamento);
            URI uri = builder.path("/equipamento/{id}").buildAndExpand(ret.id()).toUri();
            return ResponseEntity.created(uri).body(ret);
        } else {
            var err = new RuntimeException("O ID do cliente no Json do Equipamento deve ser o mesmo da URI");
            err.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/equipamento/{idEquipamento}")
    @Transactional
    public ResponseEntity<PutEquipamento> save(@PathVariable("id") Long id, @PathVariable("idEquipamento") Long idEquipamento, @RequestBody @Valid PutEquipamento eq, UriComponentsBuilder builder) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(RuntimeException::new);

        if (eq.cliente().id().equals(cliente.getId())) {
            Equipamento equip = service.findById(idEquipamento).orElseThrow();
            equip.atualizarInforamcoes(eq);
            URI uri = builder.path("/equipamento/{id}").buildAndExpand(equip.getId()).toUri();
            return ResponseEntity.created(uri).body(new PutEquipamento(equip));
        } else {
            var err = new RuntimeException("Você não está atualizando o Equipamento para o cliente correto -> O ID do cliente no Json deve ser o mesmo da URI");
            err.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    private Cliente IsValidCliente(Long id) {

        var cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }
}
