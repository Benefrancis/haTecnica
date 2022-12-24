package desafio.domain.documento.controller;

import desafio.domain.cliente.Cliente;
import desafio.domain.cliente.repository.ClienteRepository;
import desafio.domain.documento.Documento;
import desafio.domain.documento.dto.ListDocumento;
import desafio.domain.documento.dto.PutDocumento;
import desafio.domain.documento.service.DocumentoService;
import desafio.infra.EntityNotFoundException;
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

@RestController
@RequestMapping({"/cliente"})
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/{id}/documento")
    public ResponseEntity<Page<ListDocumento>> findByClienteId(@PathVariable("id") Long id, @PageableDefault(size = 10, sort = {"cliente.nome"}) Pageable paginacao) {

        var cliente = IsValidCliente(id);

        if (cliente == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(service.findByClienteId(id, paginacao).map(ListDocumento::new));
    }

    @GetMapping("/{id}/documento/{idDocumento}")
    public ResponseEntity<PutDocumento> findByClienteIdAndDocumentoId(@PathVariable("id") Long id, @PathVariable("idDocumento") Long idDocumento) {

        var cliente = IsValidCliente(id);

        if (cliente == null) return ResponseEntity.badRequest().build();

        Documento documento = service.findById(idDocumento).orElseThrow(new EntityNotFoundException("Documento não encontrado!"));

        return ResponseEntity.ok(new PutDocumento(documento));
    }

    @PostMapping("/{id}/documento")
    @Transactional
    public ResponseEntity<PutDocumento> save(@PathVariable("id") Long id, @RequestBody @Valid PutDocumento doc, UriComponentsBuilder builder) {

        var cliente = IsValidCliente(doc.cliente().id());

        if (cliente == null) return ResponseEntity.badRequest().build();

        var documento = new Documento(doc);
        documento.setCliente(cliente);
        documento = service.save(documento).orElseThrow();

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

        var documento = service.findById(doc.id()).orElseThrow(new EntityNotFoundException("Documento não encontrado!"));


        documento.setCliente(cliente);
        documento.atualizarInforamcoes(doc);
        URI uri = builder.path("/cliente/" + id + "/documento/{idDocumento}").buildAndExpand(documento.getId()).toUri();
        return ResponseEntity.ok(new PutDocumento(documento));


    }

    private Cliente IsValidCliente(Long id) {

        var cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }


}
