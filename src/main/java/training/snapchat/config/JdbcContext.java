package training.snapchat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Order(1)
public class JdbcContext {

  @Value("${db.url}")
  private String dbUrl;
  @Value("${db.username}")
  private String dbUserName;
  @Value("${db.password}")
  private String dbPassword;

  @Bean
  public DriverManagerDataSource adriverManagerDataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
    driverManagerDataSource.setUrl(this.dbUrl);
    driverManagerDataSource.setUsername(this.dbUserName);
    driverManagerDataSource.setPassword(this.dbPassword);
    return driverManagerDataSource;

  }

}
