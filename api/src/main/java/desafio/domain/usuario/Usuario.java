package desafio.domain.usuario;

import jakarta.persistence.*;

@Entity
@Table(
        name="HT_USUARIO",
        uniqueConstraints=@UniqueConstraint(columnNames={"username"}, name = "UK_USERNAME_USER")
)
public class Usuario implements Autenticavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HT_USUARIO")
    @SequenceGenerator(name = "SEQ_HT_USUARIO", sequenceName = "SEQ_HT_USUARIO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name="username", nullable = false )
    private String username;

    @Column(name="password",  nullable = false)
    private String password;


    public Usuario(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Usuario setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Usuario setPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
