package training.snapchat.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@Order(2)
@EnableJpaRepositories
public class ApplicationContext {

  @Value("${db.hibernate.hbm2ddl.auto}")
  private String dbAuto;

  @Autowired
  DriverManagerDataSource driverManagerDataSource;

  @Bean
  LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
        new LocalContainerEntityManagerFactoryBean();
    localContainerEntityManagerFactoryBean.setPackagesToScan("training.snapchat");
    localContainerEntityManagerFactoryBean
        .setPersistenceProvider(new HibernatePersistenceProvider());
    localContainerEntityManagerFactoryBean.setDataSource(driverManagerDataSource);
    localContainerEntityManagerFactoryBean.setJpaPropertyMap(getJpaPropertyMap());
    return localContainerEntityManagerFactoryBean;

  }

  private Map<String, String> getJpaPropertyMap() {
    Map<String, String> jpaMapPropety = new HashMap<String, String>();
    jpaMapPropety.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    jpaMapPropety.put("hibernate.hbm2ddl.auto", this.dbAuto);
    jpaMapPropety.put("hibernate.show_sql", Boolean.toString(true));
    return jpaMapPropety;

  }

}
