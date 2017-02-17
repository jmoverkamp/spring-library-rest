package pro.mynook.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@Configuration
@PropertySource("classpath:common.properties")
public class PropertyConfig {
    @Autowired
    private Environment environment;

    @Bean
    public String databaseUrl() {
        return this.environment.getRequiredProperty("database.jdbc.url");
    }

    @Bean
    public String databaseUser() {
        return this.environment.getRequiredProperty("database.jdbc.user");
    }

    @Bean
    public String databasePassword() {
        return this.environment.getRequiredProperty("database.jdbc.password");
    }
}
