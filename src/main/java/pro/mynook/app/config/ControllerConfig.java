package pro.mynook.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.mynook.app.controller.BookController;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@Configuration
public class ControllerConfig {
    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public BookController bookController() {
        return new BookController(this.daoConfig.bookDao());
    }
}
