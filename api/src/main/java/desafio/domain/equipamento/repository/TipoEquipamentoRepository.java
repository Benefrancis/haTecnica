package desafio.domain.equipamento.repository;

import desafio.domain.equipamento.TipoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEquipamentoRepository extends JpaRepository<TipoEquipamento, Long> {

    boolean existsByNomeIgnoreCase(String nome);
}
