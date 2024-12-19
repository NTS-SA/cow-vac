package py.gov.sigor.cow.vac.shared.infrastructure.persistence;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import py.gov.sigor.shared.infrastructure.config.Parameter;
import py.gov.sigor.shared.infrastructure.config.ParameterNotExist;
import py.gov.sigor.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class VacHibernateConfiguration {
    public static final Logger log= Logger.getLogger(VacHibernateConfiguration.class);

    private final HibernateConfigurationFactory factory;
    private final Parameter config;
    private final String                        CONTEXT_NAME = "vac";

    public VacHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("vac-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        JpaTransactionManager transactionManager =new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


    @Bean("vac-entity_manager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IOException, ParameterNotExist {
        LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("py.gov.sigor.cow.vac");
        JpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    private Properties additionalProperties() {
        Properties prop=new Properties();
        prop.setProperty("hibernate.hbm2ddl.auto","none");
        prop.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        prop.setProperty("hibernate.show_sql","false");
        prop.setProperty("hibernate.format_sql","false");
        return prop;

    }

    @Bean("vac-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("POSTGRE_DATABASE_DRIVER"),
            config.get("POSTGRE_DATABASE_URL"),
            config.get("POSTGRE_DATABASE_USER"),
            config.get("POSTGRE_DATABASE_PASSWORD")
        );
    }


}
