package py.gov.sigor.apps.vac.backend.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase pedorra para no codificar el password recibido.
 */
public class NoopPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.encode(rawPassword).equalsIgnoreCase(encodedPassword);
    }
}
