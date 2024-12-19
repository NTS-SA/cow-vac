package py.gov.sigor.apps.vac.backend;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import py.gov.sigor.shared.domain.Service;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"py.gov.sigor.shared", "py.gov.sigor.apps.vac.backend", "py.gov.sigor.cow.vac"}
)
public class VacBackendApplication {

}
