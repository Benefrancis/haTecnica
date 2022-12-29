package desafio.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import desafio.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) throws JWTCreationException, SignatureVerificationException, RuntimeException {

        try {

            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("Há Técnica")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);

        } catch (JWTCreationException exception) {
            throw new JWTCreationException("Erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) throws JWTVerificationException, SignatureVerificationException, RuntimeException {
        //The Token's Signature resulted invalid when verified using the Algorithm: HmacSHA256
        try {

            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.require(algoritmo)
                    .withIssuer("Há Técnica")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Token JWT inválido ou expirado! " + exception.getMessage());
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}