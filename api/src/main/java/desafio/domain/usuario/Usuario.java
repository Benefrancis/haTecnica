package desafio.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


@Entity
@Table(
        name = "HT_USUARIO",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"username"},
                name = "UK_USERNAME_USER"),
        indexes = @Index(
                columnList = "password",
                name = "IDX_PASSWORD"
        )

)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_USUARIO")
    @SequenceGenerator(name = "SEQ_HT_USUARIO", sequenceName = "SEQ_HT_USUARIO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }


    public Usuario setUsername(String username) {
        this.username = username;
        return this;
    }


    public Usuario setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

}
