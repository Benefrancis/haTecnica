package desafio.domain.equipamento.repository;

import desafio.domain.equipamento.Equipamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    Page<Equipamento> findByClienteId(Long id, Pageable paginacao );
}
