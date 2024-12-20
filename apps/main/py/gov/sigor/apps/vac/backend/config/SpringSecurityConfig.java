package py.gov.sigor.apps.vac.backend.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
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
import javax.sql.DataSource;


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
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception, ParameterNotExist
    {
        auth.jdbcAuthentication().dataSource(securityDataSource())
            .authoritiesByUsernameQuery("select USUARIO, GRUPO from SEGURIDAD_REALM_DATA_C where USUARIO=?")
            .usersByUsernameQuery("select USUARIO, CONTRASENA, 1 as enabled  from SEGURIDAD_REALM_DATA_C where USUARIO=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoopPasswordEncoder();
    }

    @Bean
    public DataSource securityDataSource() throws ParameterNotExist {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(config.get("WS_AUTH_DRIVER"));
        dataSource.setUrl(config.get("WS_AUTH_URL"));
        dataSource.setUsername(config.get("WS_AUTH_USER"));
        dataSource.setPassword(config.get("WS_AUTH_PASS"));
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("select 1 from dual");

        return dataSource;
    }


}
