package py.gov.sigor.apps.vac.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import py.gov.sigor.shared.infrastructure.config.Parameter;
import py.gov.sigor.shared.infrastructure.config.ParameterNotExist;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{

    private final Parameter config;

    public SpringSecurityConfig(Parameter config) {
        this.config = config;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception, ParameterNotExist {

        auth.inMemoryAuthentication()
                .withUser(config.get("WS_USER"))
                .password(passwordEncoder().encode(config.get("WS_PASS")))
                .authorities("ROLE_USER");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoopPasswordEncoder();
    }


}
