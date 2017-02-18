package pro.mynook.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.mynook.app.controller.BookController;
import pro.mynook.app.controller.advice.GlobalExceptionHandler;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@Configuration
public class ControllerConfig {
    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Bean
    public BookController bookController() {
        return new BookController(this.daoConfig.bookDao());
    }
}
