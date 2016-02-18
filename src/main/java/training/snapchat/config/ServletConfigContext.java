package training.snapchat.config;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ServletConfigContext extends AnnotationConfigApplicationContext {

  @Bean
  PropertyPlaceholderConfigurer propertyPlaceholder() throws IOException {
    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer =
        new PropertyPlaceholderConfigurer();
    propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
    propertyPlaceholderConfigurer.setLocations(
        getResources("config/" + System.getProperty("application.env") + "/*.properties"));
    return propertyPlaceholderConfigurer;

  }

}
