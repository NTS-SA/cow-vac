package py.gov.sigor.apps.vac.backend.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomContextPath {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>  webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/vac-api");
    }
}
