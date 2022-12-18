package desafio.domain.usuario;

public interface Autenticavel {
    public String getUsername();

    public String getPassword();

    public Autenticavel setUsername(String username);

    public Autenticavel setPassword(String password);

}
