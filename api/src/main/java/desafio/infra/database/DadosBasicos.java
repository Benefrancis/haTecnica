package desafio.infra.database;

import desafio.domain.cliente.TipoCliente;
import desafio.domain.cliente.repository.TipoClienteRepository;
import desafio.domain.documento.TipoDocumento;
import desafio.domain.documento.repository.TipoDocumentoRepository;
import desafio.domain.endereco.Estado;
import desafio.domain.endereco.Pais;
import desafio.domain.endereco.repository.CidadeRepository;
import desafio.domain.endereco.repository.EstadoRepository;
import desafio.domain.endereco.repository.PaisRepository;
import desafio.domain.equipamento.TipoEquipamento;
import desafio.domain.equipamento.repository.TipoEquipamentoRepository;
import desafio.domain.servico.TipoServico;
import desafio.domain.servico.repository.TipoServicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class DadosBasicos implements ApplicationRunner {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;
    @Autowired
    private TipoServicoRepository tipoServicoRepository;


    /**
     * Popula Tabelas do Banco de Dados com os dados iniciais para o sistema
     * <p>
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Persistindo Tipos Básicos de Clientes
        log.info("Populando database com os Tipos de Clientes...");
        List<TipoCliente> tiposDeCliente = Arrays.asList(TipoCliente.PF(), TipoCliente.PJ());

        tiposDeCliente.forEach(tc -> {
            if (!tipoClienteRepository.existsById(tc.getId())) tipoClienteRepository.save(tc);
        });

        //Persistindo Tipos Básicos de Equipamentos
        log.info("Populando database com os Tipos de Equipamentos...");
        List<TipoEquipamento> tiposDeEquipamento = Arrays.asList(
                TipoEquipamento.COMPUTADOR(),
                TipoEquipamento.NOTEBOOK(),
                TipoEquipamento.CELULAR(),
                TipoEquipamento.TABLET(),
                TipoEquipamento.VIDEO_GAME()
        );

        tiposDeEquipamento.forEach(te -> {
            if (!tipoEquipamentoRepository.existsByNomeIgnoreCase(te.getNome())) tipoEquipamentoRepository.save(te);
        });

        //Persistindo Tipos Básicos de Serviços
        log.info("Populando database com os Tipos de Serviços...");
        List<TipoServico> tiposDeServicos = Arrays.asList(
                TipoServico.ORCAMENTO(),
                TipoServico.VISITA_TECNICA(),
                TipoServico.LIMPEZA(),
                TipoServico.SUBSTITUICAO_DE_PECA(),
                TipoServico.UPGRADE_DE_SISTEMA_OPERACIONAL(),
                TipoServico.INSTALACAO_DE_SOFTWARE()
        );

        tiposDeServicos.forEach(ts -> {
            if (!tipoServicoRepository.existsByNomeIgnoreCase(ts.getNome())) tipoServicoRepository.save(ts);
        });

        //Persistindo Tipos Básicos de Documentos
        log.info("Populando database com os Tipos de Documentos...");
        List<TipoDocumento> tiposDeDocumentos = Arrays.asList(
                TipoDocumento.RG(),
                TipoDocumento.CPF(),
                TipoDocumento.CNPJ()
        );

        tiposDeDocumentos.forEach(td -> {
            if (!tipoDocumentoRepository.existsByNomeIgnoreCase(td.getNome())) tipoDocumentoRepository.save(td);
        });


        //Persistindo Tipos Básicos de País
        log.info("Populando database com os dados do Brasil...");
        List<Pais> paises = Arrays.asList(
                Pais.BRASIL()
        );

        paises.forEach(p -> {
            if (!paisRepository.existsByNomeIgnoreCase(p.getNome())) paisRepository.save(p);
        });


        //Persistindo Tipos Básicos de Estados Brasileiros
        log.info("Populando database com os Estados do Brasil...");
        List<Estado> estados = Arrays.asList(
                Estado.SP(),
                Estado.PR(),
                Estado.SC(),
                Estado.RS(),
                Estado.MS(),
                Estado.RO(),
                Estado.AC(),
                Estado.AM(),
                Estado.RR(),
                Estado.PA(),
                Estado.AP(),
                Estado.TO(),
                Estado.MA(),
                Estado.RN(),
                Estado.PB(),
                Estado.PE(),
                Estado.AL(),
                Estado.SE(),
                Estado.BA(),
                Estado.MG(),
                Estado.RJ(),
                Estado.MT(),
                Estado.GO(),
                Estado.DF(),
                Estado.PI(),
                Estado.CE(),
                Estado.ES()
        );

        estados.forEach(e -> {
            if (!estadoRepository.existsBySiglaIgnoreCase(e.getSigla())) estadoRepository.save(e);
        });


    }
}
