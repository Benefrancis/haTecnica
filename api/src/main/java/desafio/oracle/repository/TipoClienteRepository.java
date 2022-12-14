package desafio.oracle.repository;

import desafio.model.cliente.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {
}
