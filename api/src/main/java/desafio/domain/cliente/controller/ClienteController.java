package desafio.domain.cliente.controller;


import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.dto.ListCliente;
import desafio.domain.cliente.dto.PutCliente;
import desafio.domain.cliente.dto.PutTipoCliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.cliente.repository.TipoClienteRepository;
import desafio.domain.cliente.service.ClienteService;
import desafio.domain.documento.Documento;
import desafio.domain.documento.dto.ListDocumento;
import desafio.domain.documento.dto.PutDocumento;
import desafio.domain.documento.service.DocumentoService;
import desafio.domain.equipamento.Equipamento;
import desafio.domain.equipamento.dto.ListEquipamento;
import desafio.domain.equipamento.dto.PutEquipamento;
import desafio.domain.equipamento.service.EquipamentoService;
import desafio.infra.exceptions.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService service;

    @Autowired
    private DocumentoService documentoService;


    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private ClienteRepository repository;


    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    @GetMapping("/tipo")
    public Page<PutTipoCliente> findAllTipo(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return tipoClienteRepository.findAll(paginacao).map(PutTipoCliente::new);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<PutCliente> save(@RequestBody @Valid PutCliente dados, UriComponentsBuilder builder) {
        var cliente = service.save(new Cliente(dados));
        URI uri = builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PutCliente(cliente));
    }

    @PutMapping
    @Transactional
    public void atualizarPessoaFisica(@RequestBody @Valid PutCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @GetMapping
    public Page<ListCliente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(ListCliente::new);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PutCliente> findById(@PathVariable Long id) {
        log.info("Recebido o pedido de informações do cliente com id  {}", id);
        var cliente = service.findById(id);
        if (cliente != null) {
            return ResponseEntity.ok(new PutCliente(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}/documento")
    public ResponseEntity<Page<ListDocumento>> findDocumentoByClienteId(@PathVariable("id") Long id, @PageableDefault(size = 10, sort = {"cliente.nome"}) Pageable paginacao) {

        var cliente = IsValidCliente(id);

        if (cliente == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(documentoService.findByClienteId(id, paginacao).map(ListDocumento::new));
    }

    @GetMapping("/{id}/documento/{idDocumento}")
    public ResponseEntity<PutDocumento> findByClienteIdAndDocumentoId(@PathVariable("id") Long id, @PathVariable("idDocumento") Long idDocumento) {

        var cliente = IsValidCliente(id);

        if (cliente == null) return ResponseEntity.badRequest().build();

        Documento documento = documentoService.findById(idDocumento).orElseThrow(new EntityNotFoundException("Documento não encontrado!"));

        return ResponseEntity.ok(new PutDocumento(documento));
    }

    @PostMapping("/{id}/documento")
    @Transactional
    public ResponseEntity<PutDocumento> save(@PathVariable("id") Long id, @RequestBody @Valid PutDocumento doc, UriComponentsBuilder builder) {

        var cliente = IsValidCliente(doc.cliente().id());

        if (cliente == null) return ResponseEntity.badRequest().build();

        var documento = new Documento(doc);
        documento.setCliente(cliente);
        documento = documentoService.save(documento).orElseThrow();

        var ret = new PutDocumento(documento);
        URI uri = builder.path("/cliente/" + id + "/documento/{idDocumento}").buildAndExpand(ret.id()).toUri();
        return ResponseEntity.created(uri).body(ret);

    }

    /**
     * <p>
     * O método PUT solicita que o estado do recurso alvo seja criado ou substituído com o estado definido pela representação incluído na mensagem de solicitação de carga útil. Um PUT bem-sucedido de uma determinada representação sugeriria que um GET subsequente sobre esse mesmo recurso alvo resultará em uma representação equivalente sendo enviado em uma resposta de 200 (OK). Entretanto, não há garantia de que tal mudança de estado seja observável, uma vez que o recurso alvo pode ser agido por outros agentes do usuário em paralelo, ou pode ser sujeito a processamento dinâmico pelo servidor de origem, antes de qualquer é recebido o GET subsequente. Uma resposta bem-sucedida só implica que a intenção do agente do usuário foi alcançada no momento de seu processamento pelo servidor de origem.
     * </p>
     * <br />
     * <p>
     * Se o recurso alvo não tiver uma representação atual e o PUT cria com sucesso um, então o servidor de origem DEVE informar o agente do usuário, enviando uma resposta 201 (Criada). Se o alvo recurso tem uma representação atual e essa representação é modificado com sucesso de acordo com o estado do anexo representação, então o servidor de origem DEVE enviar ou 200 (OK) ou uma resposta 204 (Sem conteúdo) para indicar a conclusão bem-sucedida do solicitação.
     * </p>
     *
     * @param id
     * @param idDocumento
     * @param doc
     * @param builder
     * @return
     * @see <a href="https://datatracker.ietf.org/doc/html/rfc7231#section-4.3.4">PUT</a>
     */
    @PutMapping("/{id}/documento/{idDocumento}")
    @Transactional
    public ResponseEntity<PutDocumento> update(@PathVariable("id") Long id, @PathVariable("idDocumento") Long idDocumento, @RequestBody @Valid PutDocumento doc, UriComponentsBuilder builder) {

        var cliente = IsValidCliente(doc.cliente().id());

        if (cliente == null) return ResponseEntity.badRequest().build();

        var documento = documentoService.findById(doc.id()).orElseThrow(new EntityNotFoundException("Documento não encontrado!"));


        documento.setCliente(cliente);
        documento.atualizarInforamcoes(doc);
        URI uri = builder.path("/cliente/" + id + "/documento/{idDocumento}").buildAndExpand(documento.getId()).toUri();
        return ResponseEntity.ok(new PutDocumento(documento));


    }


    @GetMapping("/{id}/equipamento")
    public ResponseEntity<Page<ListEquipamento>> findEquioamentoByClienteId(@PathVariable("id") Long id, @PageableDefault(size = 10, sort = {"cliente.nome"}) Pageable paginacao) {
        var cliente = IsValidCliente(id);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(equipamentoService.findByClienteId(id, paginacao).map(ListEquipamento::new));
    }

    @PostMapping("/{id}/equipamento")
    @Transactional
    public ResponseEntity<PutEquipamento> save(@PathVariable("id") Long id, @RequestBody @Valid PutEquipamento eq, UriComponentsBuilder builder) {

        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente != null && eq.cliente().id().equals(cliente.getId())) {
            var equipamento = new Equipamento(eq);
            equipamento.setCliente(cliente);
            equipamento = equipamentoService.save(equipamento).orElse(null);
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

        Cliente cliente = repository.findById(id).orElseThrow(RuntimeException::new);

        if (eq.cliente().id().equals(cliente.getId())) {
            Equipamento equip = equipamentoService.findById(idEquipamento).orElseThrow();
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
        var cliente = repository.findById(id).orElse(null);
        return cliente;
    }


}
