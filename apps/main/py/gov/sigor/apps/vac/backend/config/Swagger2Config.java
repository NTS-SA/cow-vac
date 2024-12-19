package py.gov.sigor.apps.vac.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("py.gov.sigor.apps.vac.backend.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfo("COW VAC REST API",
            "Es el API utilizado por SIGOR/SIAP para obtener cantidad de animales terneros, terneras, bovino y bubalinos vacunados.",
            "1.0",
            "API Terms of Service URL",
            new Contact("Soporte NTS", "www.nts.com.py", "soporte@nts.com.py"),
            "API License",
            "API License URL",
            Collections.emptyList()
        );
    }
}
