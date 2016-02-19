package training.snapchat.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Order(2)
@EnableJpaRepositories("training.snapchat")
@EnableTransactionManagement
public class ApplicationContext {

	@Value("${db.hibernate.hbm2ddl.auto}")
	private String dbAuto;

	@Autowired
	DriverManagerDataSource driverManagerDataSource;

	@Bean
	EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPackagesToScan("training.snapchat");
		factory.setPersistenceProvider(new HibernatePersistenceProvider());
		factory.setDataSource(driverManagerDataSource);
		factory.setJpaPropertyMap(getJpaPropertyMap());
		/*HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		factory.setJpaVendorAdapter(vendorAdapter);*/
		factory.afterPropertiesSet();
		return factory.getObject();

	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	private Map<String, String> getJpaPropertyMap() {
		Map<String, String> jpaMapPropety = new HashMap<String, String>();
		jpaMapPropety.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		jpaMapPropety.put("hibernate.hbm2ddl.auto", this.dbAuto);
		jpaMapPropety.put("hibernate.show_sql", Boolean.toString(true));
		return jpaMapPropety;
	}

}
