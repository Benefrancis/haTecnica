package desafio.domain.usuario.repository;

import desafio.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsernameIgnoreCase(String username) throws UsernameNotFoundException;


    boolean existsByUsernameIgnoreCase(String username);


}
